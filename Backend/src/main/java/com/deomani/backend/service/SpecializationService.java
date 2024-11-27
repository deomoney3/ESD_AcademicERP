package com.deomani.backend.service;
import com.deomani.backend.dto.*;
import com.deomani.backend.entity.Courses;
import com.deomani.backend.entity.Specialization;
import com.deomani.backend.entity.SpecializationCourse;
import com.deomani.backend.mapper.SpecializationCourseMapper;
import com.deomani.backend.mapper.SpecializationMapper;
import com.deomani.backend.repo.CoursesRepo;
import com.deomani.backend.repo.SpecializationCourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.deomani.backend.repo.SpecializationRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.deomani.backend.mapper.CourseMapper;

@Service
@RequiredArgsConstructor
public class SpecializationService {
    private final SpecializationRepo specializationRepo;
    private final SpecializationMapper mapper;
    private final SpecializationCourseRepo specializationCourseRepo;
    private final CoursesRepo coursesRepo;

    private final SpecializationCourseMapper specializationCourseMapper;

    public String createSpecialization(SpecializationRequest request) {
        Specialization specialization = mapper.toEntity(request);
        specializationRepo.save(specialization);
        return "Specialization Created Successfully";
    }

    public Specialization updateSpecialization(SpecializationRequest request,String id) {
        Specialization specialization = specializationRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Specialization not found with name: " + id)
        );
        specialization.setCode(request.code());
        specialization.setName(request.name());
        specialization.setDescription(request.description());
        specialization.setYear(request.year());
        specialization.setCredits_required(request.credits_required());
        return specializationRepo.save(specialization);
    }

    public List<Specialization> getAllSpecialization() {
        return specializationRepo.findAll();
    }

    public SpecializationResponse getSpecializationById(String id) {
        Specialization specialization = specializationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        return SpecializationMapper.toSpecializationResponse(specialization);
    }

    public void deleteSpecializationById(String id) {
        specializationRepo.deleteById(id);
    }

    public String createCourse(SpecializationCourseRequest request) {
        Optional<Specialization> specialization = specializationRepo.findById(request.specialization_id());
        if(!specialization.isPresent()) {
            return "Specialization Not Found";
        }
        Optional<Courses> courses = coursesRepo.findById(request.course_id());
        if(!courses.isPresent()) {
            return "Course Not Found";
        }
        SpecializationCourse specializationCourse = specializationCourseMapper.toEntity(request);
        specializationCourseRepo.save(specializationCourse);

        return "Course Created Successfully";
    }

    public SpecializationWithCoursesResponse getSpecializationWithCourses(String specializationId) {
        // Fetch specialization details
        Specialization specialization = specializationRepo.findById(specializationId)
                .orElseThrow(() -> new RuntimeException("Specialization not found with ID: " + specializationId));

        // Fetch all specialization_course mappings for the specialization
        List<SpecializationCourse> specializationCourses = specializationCourseRepo.findBySpecializationId(specializationId);

//        List<CourseResponse> courses = new ArrayList<>();

//        for(SpecializationCourse sc : specializationCourses){
//            System.out.println(sc.getCourse_id());
//            Courses course = coursesRepo.findById(sc.getCourse_id()).get();
//            System.out.println(course);
//            courses.add(CourseMapper.toCourseResponse(course));
//        }

        // Fetch courses based on course IDs
        List<CourseResponse> courses = specializationCourses.stream()
                .map(sc -> coursesRepo.findById(sc.getCourse_id())
                        .map(CourseMapper::toCourseResponse)
                        .orElseThrow(() -> new RuntimeException("Course not found with ID: " + sc.getCourse_id())))
                .collect(Collectors.toList());

        // Return combined response
        return new SpecializationWithCoursesResponse(
                specialization.getSpecialization_id(),
                specialization.getCode(),
                specialization.getName(),
                specialization.getDescription(),
                specialization.getYear(),
                specialization.getCredits_required(),
                courses
        );
    }

}