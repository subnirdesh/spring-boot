package com.nirdesh.coursemanager.dto.coursematerial;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseMaterialRequest(
        @NotBlank(message = " url  is required")
        String url,
        @NotBlank(message = "Course Id is required.")
        long courseId
) {}
