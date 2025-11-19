package com.nirdesh.studentmanagement.service;

import com.nirdesh.studentmanagement.entity.Course;
import com.nirdesh.studentmanagement.repository.CourseRepository;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    List<Course> getAllStudents();
}
