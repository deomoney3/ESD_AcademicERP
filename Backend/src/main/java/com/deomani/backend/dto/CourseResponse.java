package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseResponse(
        @JsonProperty("course_id")
        String course_id,
        @JsonProperty("course_code")
        String course_code,
        @JsonProperty("name")
        String name,
        @JsonProperty("description")
        String description,
        @JsonProperty("year")
        String year,
        @JsonProperty("term")
        String term,
        @JsonProperty("faculty")
        String faculty,
        @JsonProperty("credits")
        String credits,
        @JsonProperty("capacity")
        String capacity
) {
}
