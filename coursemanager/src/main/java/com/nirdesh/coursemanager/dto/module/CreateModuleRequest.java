package com.nirdesh.coursemanager.dto.module;

import jakarta.validation.constraints.NotBlank;

public record CreateModuleRequest(
        @NotBlank(message = " Module Name is required.")
        String moduleName,
        @NotBlank(message = " Module Code is required.")
        String moduleCode,
        String description,
        @NotBlank(message = "Course Id is reuqired")
        Long courseId
) {}
