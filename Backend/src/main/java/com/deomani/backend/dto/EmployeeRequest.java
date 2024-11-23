package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record EmployeeRequest(
        @NotNull(message = "Employee_id should be present")
        @NotEmpty(message = "Employee_id should be present")
        @NotBlank(message = "Employee_id should be present")
        @JsonProperty("employee_id")
        String employee_id,

        @NotNull(message = "Employee should be present")
        @NotEmpty(message = "Employee should be present")
        @NotBlank(message = "Employee should be present")
        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        @NotNull(message="Employee email is required")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email")
        String email,

        @NotNull(message = "Password should be present")
        @NotEmpty(message = "Password should be present")
        @NotBlank(message = "Password should be present")
        @Size(min = 6, max = 18)
        @JsonProperty("password")
        String password,

        @NotNull(message = "title should be present")
        @NotEmpty(message = "title should be present")
        @NotBlank(message = "title should be present")
        @JsonProperty("title")
        String title,

        @NotNull(message = "Department should be present")
        @NotEmpty(message = "Department should be present")
        @NotBlank(message = "Department should be present")
        @JsonProperty("department")
        String department
) {
}
