package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    // Get All Course
    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> getAllCourses(){
        List<CourseResponse> courses=courseService.getAllCourses();

        ApiResponse<List<CourseResponse>> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Course fetched successfully",
                courses
        );

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> getCourse(@PathVariable Long id){
        CourseResponse course=courseService.getCourse(id);

        ApiResponse<CourseResponse> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Course fetched successfully",
                course
        );
        return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>>  createCourse(@RequestBody CreateCourseRequest request){
        CourseResponse course=courseService.createCourse(request);

        ApiResponse<CourseResponse> response=ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Course created successfully",
                course
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{code}")
    public ResponseEntity<ApiResponse<CourseResponse>> updateCourse(@PathVariable String code,@RequestBody UpdateCourseRequest request) {
        CourseResponse course = courseService.updateCourse(code, request);

        ApiResponse<CourseResponse> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Course updated successfully",
                course
        );

        return ResponseEntity.ok(response);

    }

    }



