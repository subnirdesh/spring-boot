package com.nirdesh.coursemanager.dto.teacher;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTeacherRequest(
        @NotBlank(message = " First Name is required.")
        String firstName,
        @NotBlank(message = "Last Name is required.")
        String lastName,
        @Email
        @NotBlank(message = "Email is required.")
        String email,
        @NotBlank(message = "Phone is required.")
        String phone,
        @NotNull(message = "Module Id is required.")
        Long moduleId
) {

}
