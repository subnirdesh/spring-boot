package com.nirdesh.coursemanager.dto.course;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Optional;

public record UpdateCourseRequest(
        Long id,
        String courseName,
        String description,
        Integer credit

){}
