package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(

        @NotNull(message = "course_id should be present")
        @NotEmpty(message = "course_id should be present")
        @NotBlank(message = "course_id should be present")
        @JsonProperty("course_id")
        String course_id,

        @NotNull(message = "course_code should be present")
        @NotEmpty(message = "course_code should be present")
        @NotBlank(message = "course_code should be present")
        @JsonProperty("course_code")
        String course_code,

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

        @NotNull(message = "term should be present")
        @NotEmpty(message = "term should be present")
        @NotBlank(message = "term should be present")
        @JsonProperty("term")
        String term,

        @NotNull(message = "faculty should be present")
        @NotEmpty(message = "faculty should be present")
        @NotBlank(message = "faculty should be present")
        @JsonProperty("faculty")
        String faculty,

        @NotNull(message = "credits should be present")
        @NotEmpty(message = "credits should be present")
        @NotBlank(message = "credits should be present")
        @JsonProperty("credits")
        String credits,

        @NotNull(message = "capacity should be present")
        @NotEmpty(message = "capacity should be present")
        @NotBlank(message = "capacity should be present")
        @JsonProperty("capacity")
        String capacity


) {

}
