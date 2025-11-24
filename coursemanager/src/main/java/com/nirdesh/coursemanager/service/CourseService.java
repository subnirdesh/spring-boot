package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.entity.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    List<Course> getAllStudents();
}
