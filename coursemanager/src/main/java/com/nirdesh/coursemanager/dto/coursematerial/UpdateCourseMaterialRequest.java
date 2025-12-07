package com.nirdesh.coursemanager.dto.coursematerial;

public record UpdateCourseMaterialRequest(
        String url,
        Long courseId
) { }
