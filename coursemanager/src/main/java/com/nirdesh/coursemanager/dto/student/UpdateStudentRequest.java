package com.nirdesh.coursemanager.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateStudentRequest(

        String firstName,
        String lastName,
        String email,
        String guardianName,
        String guardianPhone,
        Long courseId
) {}
