package com.nirdesh.coursemanager.dto.module;

public record UpdateModuleRequest (
        String moduleName,
        String moduleCode,
        String description,
        Long courseId
){
}
