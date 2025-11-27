package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest request);

}
