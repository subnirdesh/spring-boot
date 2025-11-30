package com.nirdesh.coursemanager.dto.student;

import com.nirdesh.coursemanager.entity.Course;

public record StudentResponse(
        long id,
        String firstName,
        String lastName,
        String rollNo,
        String email,
        Long courseId
) {
}
