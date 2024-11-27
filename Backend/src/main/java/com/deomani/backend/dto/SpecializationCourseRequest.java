package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SpecializationCourseRequest(

    @NotNull(message = "specialization_id should be present")
    @NotEmpty(message = "specialization_id should be present")
    @NotBlank(message = "specialization_id should be present")
    @JsonProperty("specialization_id")
    String specialization_id,

    @NotNull(message = "course_id should be present")
    @NotEmpty(message = "course_id should be present")
    @NotBlank(message = "course_id should be present")
    @JsonProperty("course_id")
    String course_id
){
}
