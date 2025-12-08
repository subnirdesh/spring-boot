package com.nirdesh.coursemanager.dto.module;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateModuleRequest(
        @NotBlank(message = " Module Code is required.")
        String moduleCode,
        @NotBlank(message = " Module Name is required.")
        String moduleName,
        String description,
        @NotNull(message = "Course Id is reuqired")
        Long courseId
) {}
