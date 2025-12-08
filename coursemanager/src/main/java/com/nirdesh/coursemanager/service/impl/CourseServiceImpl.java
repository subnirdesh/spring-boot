package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.CourseMapper;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
           throw new ApiException("Course already exists with code :  " + request.courseCode(),
                                    HttpStatus.CONFLICT);
        }

        Course course=mapper.toEntity(request);
        courseRepository.save(course);

        return mapper.toResponse(course);

    }


    @Override
    @Transactional
    public CourseResponse updateCourse(String courseCode, UpdateCourseRequest request) {

        Course existingCourse=courseRepository.findByCourseCode(courseCode)
                .orElseThrow(()-> new ApiException(
                        "Course not Found with code: "+ courseCode,
                        HttpStatus.NOT_FOUND
                ));

        mapper.updateEntity(request,existingCourse);

        return mapper.toResponse(courseRepository.save(existingCourse));
    }


    @Override
    public List<CourseResponse> getAllCourses() {
        return mapper.toResponseList(courseRepository.findAll());

    }

    @Override
    public CourseResponse getCourse(Long id) {

        Course course=courseRepository.findById(id)
                .orElseThrow(() -> new ApiException("Course not Found with ID: "+id,
                                                      HttpStatus.NOT_FOUND
                                                    ));

        return mapper.toResponse(course);
    }




}
