package com.deomani.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpecializationResponse(
        @JsonProperty("specialization_id")
        String specialization_id,
        @JsonProperty("code")
        String code,
        @JsonProperty("name")
        String name,
        @JsonProperty("description")
        String description,
        @JsonProperty("year")
        String year,
        @JsonProperty("credits_required")
        String credits_required
) {
}
