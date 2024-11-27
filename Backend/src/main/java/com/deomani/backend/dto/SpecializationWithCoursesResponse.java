package com.deomani.backend.dto;

import java.util.List;

public record SpecializationWithCoursesResponse(
        String specialization_id,
        String code,
        String name,
        String description,
        String year,
        String credits_required,
        List<CourseResponse> courses
) {
}
