package com.deomani.backend.mapper;

import com.deomani.backend.dto.CourseRequest;
import com.deomani.backend.dto.CourseResponse;
import com.deomani.backend.entity.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseMapper {
    public Courses toEntity(CourseRequest request) {
        return Courses.builder()
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

    public static CourseResponse toCourseResponse(Courses courses) {

        return new CourseResponse(
                courses.getCourse_id(),
                courses.getCourse_code(),
                courses.getName(),
                courses.getDescription(),
                courses.getYear(),
                courses.getTerm(),
                courses.getFaculty(),
                courses.getCredits(),
                courses.getCapacity()
        );
    }

}
