package com.nirdesh.coursemanager.dto.coursematerial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record CreateCourseMaterialRequest(
        @NotNull(message = "Course Id is required.")
        @Positive(message = "Course Id must be positive")
        Long courseId,
        @NotBlank(message = " url  is required")
        String url

) {}
