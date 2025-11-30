package com.nirdesh.coursemanager.dto.module;

public record ModuleResponse(
        Long id,
        String moduleName,
        String moduleCode,
        String description,
        Long courseId
) {
}
