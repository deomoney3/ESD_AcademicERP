package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

public record SpecializationCourseRequest(
    @NotNull
    @JsonProperty("specialization_id")
    String specialization_id,
    @NotNull
    @JsonProperty("course_id")
    String course_id
){
}
