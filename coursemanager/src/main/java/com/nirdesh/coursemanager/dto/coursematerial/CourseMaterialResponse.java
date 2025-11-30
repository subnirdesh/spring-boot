package com.nirdesh.coursemanager.dto.coursematerial;

public record CourseMaterialResponse(
        Long id,
        String url,
        Long courseId) { }
