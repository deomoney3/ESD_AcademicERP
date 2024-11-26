package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SpecializationRequest(

        @NotNull(message = "specialization_id should be present")
        @NotEmpty(message = "specialization_id should be present")
        @NotBlank(message = "specialization_id should be present")
        @JsonProperty("specialization_id")
        String specialization_id,

        @NotNull(message = "course_code should be present")
        @NotEmpty(message = "course_code should be present")
        @NotBlank(message = "course_code should be present")
        @JsonProperty("code")
        String code,

        @NotNull(message = "name should be present")
        @NotEmpty(message = "name should be present")
        @NotBlank(message = "name should be present")
        @JsonProperty("name")
        String name,

        @NotNull(message = "description should be present")
        @NotEmpty(message = "description should be present")
        @NotBlank(message = "description should be present")
        @JsonProperty("description")
        String description,

        @NotNull(message = "year should be present")
        @NotEmpty(message = "year should be present")
        @NotBlank(message = "year should be present")
        @JsonProperty("year")
        String year,

        @NotNull(message = "credits should be present")
        @NotEmpty(message = "credits should be present")
        @NotBlank(message = "credits should be present")
        @JsonProperty("credits_required")
        String credits_required
) {

}
