package com.nirdesh.coursemanager.dto.teacher;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.*;

import java.util.List;

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
        @NotNull(message = "Module Ids are required.")
        @NotEmpty(message = "At least one module must be assigned.")
        @Size(min = 1, message = "At least one module must be assigned.")
        List<Long> moduleId
) {

}
