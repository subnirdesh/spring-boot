package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.mapper.CourseMapper;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper mapper;


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
    public CourseResponse updateCourse(Long id, UpdateCourseRequest request) {
        return null;
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return List.of();
    }

    @Override
    public CourseResponse getCourse() {
        return null;
    }
}
