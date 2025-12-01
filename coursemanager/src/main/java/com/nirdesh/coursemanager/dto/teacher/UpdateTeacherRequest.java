package com.nirdesh.coursemanager.dto.teacher;

import java.util.List;

public record UpdateTeacherRequest(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        List<Long> moduleId
) {
}
