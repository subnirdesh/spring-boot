package com.nirdesh.studentmanagement.service.impl;

import com.nirdesh.studentmanagement.entity.Course;
import com.nirdesh.studentmanagement.repository.CourseRepository;
import com.nirdesh.studentmanagement.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllStudents() {
        return courseRepository.findAll();
    }
}
