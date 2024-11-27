package com.deomani.backend.service;

import com.deomani.backend.repo.SpecializationCourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationCourseService {
    private final SpecializationCourseRepo specializationCourseRepo;
    public void deleteSpecializationById(String id) {

        specializationCourseRepo.deleteById(id);
    }
}
