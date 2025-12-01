package com.nirdesh.coursemanager.dto.teacher;

import java.util.List;

public record  TeacherResponse (
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        List<Long> moduleId
){
}
