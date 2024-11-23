package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponse (
        @JsonProperty("employee_id")
        String employee_id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("email")
        String email,
        @JsonProperty("title")
        String title,
        @JsonProperty("department")
        String department
) {
}