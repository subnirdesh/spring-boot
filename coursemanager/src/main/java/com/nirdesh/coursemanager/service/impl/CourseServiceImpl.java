package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.exception.ResourceNotFoundException;
import com.nirdesh.coursemanager.mapper.CourseMapper;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper mapper;
    private final CourseMapper courseMapper;


    @Override
    @Transactional
    public CourseResponse createCourse(CreateCourseRequest request) {

        if(courseRepository.existsByCourseCode(request.courseCode())){
            throw new IllegalArgumentException("Course Code already exists.");
        }

        Course course=mapper.toEntity(request);
        courseRepository.save(course);

        return mapper.toResponse(course);

    }

    @Override
    @Transactional
    public CourseResponse updateCourse(Long id, UpdateCourseRequest request) {

        Course course=courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Teacher not Found with ID: "+id));

        mapper.updateEntity(request,course);

        return mapper.toResponse(courseRepository.save(course));
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return mapper.toResponseList(courseRepository.findAll());

    }

    @Override
    public CourseResponse getCourse(Long id) {

        Course course=courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not Found with ID: "+id));

        return mapper.toResponse(course);
    }


}
