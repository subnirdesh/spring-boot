package com.nirdesh.coursemanager.dto.course;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record CreateCourseRequest (

        @NotBlank(message="Course Code is required.")
        String courseCode,
        @NotBlank(message="Course Name is required.")
        String courseName,
        @NotBlank(message = "Description is required.")
        String description,
        @NotBlank(message="Credit is required.")
        Integer credit
){}
