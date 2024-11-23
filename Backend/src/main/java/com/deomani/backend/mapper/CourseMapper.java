package com.deomani.backend.mapper;

import com.deomani.backend.dto.CourseRequest;
import com.deomani.backend.entity.CourseSpecialization;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {
    public CourseSpecialization toEntity(CourseRequest request) {
        return CourseSpecialization.builder()
                .course_id(request.course_id())
                .course_code(request.course_code())
                .name(request.name())
                .description(request.description())
                .year(request.year())
                .term(request.term())
                .faculty(request.faculty())
                .credits(request.credits())
                .capacity(request.capacity())
                .build();
    }

}
