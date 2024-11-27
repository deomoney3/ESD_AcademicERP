package com.deomani.backend.mapper;

import com.deomani.backend.dto.SpecializationCourseRequest;
import com.deomani.backend.entity.Employee;
import com.deomani.backend.entity.Specialization;
import com.deomani.backend.entity.SpecializationCourse;
import org.springframework.stereotype.Service;

@Service
public class SpecializationCourseMapper {

    public SpecializationCourse toEntity(SpecializationCourseRequest request) {
        return SpecializationCourse.builder()
                .specialization_id(request.specialization_id())
                .course_id(request.course_id())
                .build();
    }
}
