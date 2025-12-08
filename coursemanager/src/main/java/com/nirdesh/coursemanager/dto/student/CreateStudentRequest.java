package com.nirdesh.coursemanager.dto.student;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudentRequest (
        @NotBlank(message = "Roll No is required")
        String rollNo,
        @NotBlank(message = "First Name is required.")
        String firstName,
        @NotBlank(message = "Last Name is required.")
        String lastName,
        @Email
        @NotBlank(message = "Email is required. ")
        String email,
        @NotBlank(message = "Guardian Name is required. ")
        String guardianName,
        @NotBlank(message = "Guardian Phone is required. ")
        String guardianPhone,
        @NotNull(message = "Course Id is required.")
        Long courseId

)
{
}
