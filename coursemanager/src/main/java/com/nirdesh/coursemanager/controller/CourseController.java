package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public List<Course> getAllStudents(){
        return courseService.getAllStudents();
    }


    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

}
