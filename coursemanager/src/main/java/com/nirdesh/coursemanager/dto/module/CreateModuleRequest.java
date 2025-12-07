package com.nirdesh.coursemanager.dto.module;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateModuleRequest(
        @NotBlank(message = " Module Name is required.")
        String moduleName,
        @NotBlank(message = " Module Code is required.")
        String moduleCode,
        String description,
        @NotNull(message = "Course Id is reuqired")
        Long courseId
) {}
