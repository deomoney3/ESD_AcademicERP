package com.deomani.backend.controller;

import com.deomani.backend.dto.*;
import com.deomani.backend.entity.Specialization;
import com.deomani.backend.helper.JWTHelper;
import com.deomani.backend.service.SpecializationCourseService;
import com.deomani.backend.service.SpecializationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/specialization")
public class SpecializationController {

    private final SpecializationService specializationService;
    private final JWTHelper jwtHelper;
    private final SpecializationCourseService specializationCourseService;

    @PostMapping()
    public ResponseEntity<String> createSpecialization(@RequestHeader("Authorization") String token, @RequestBody @Valid SpecializationRequest request) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);
        return ResponseEntity.ok(specializationService.createSpecialization(request));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@RequestHeader("Authorization") String token,@RequestBody SpecializationRequest request, @PathVariable String id) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);

        return ResponseEntity.ok(specializationService.updateSpecialization(request,id));
    }

    @GetMapping()
    public ResponseEntity<List<Specialization>> getAllSpecializations(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);

        return ResponseEntity.ok(specializationService.getAllSpecialization());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationResponse> getSpecializationById(@RequestHeader("Authorization") String token,@PathVariable String id) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);

        SpecializationResponse specialization = specializationService.getSpecializationById(id);
        return ResponseEntity.ok(specialization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecializationById(@RequestHeader("Authorization") String token,@PathVariable String id) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);

        specializationService.deleteSpecializationById(id);
        specializationCourseService.deleteSpecializationById(id);

        return ResponseEntity.ok("Specialization deleted successfully");
    }

    private void validateTokenForEmail(String token, String email) {
        String extractedEmail = jwtHelper.extractUsername(token);
        if (!extractedEmail.equals(email)) {
            throw new RuntimeException("Unauthorized: Token does not match provided email");
        }
    }

    @PostMapping( "/Courses")
    public ResponseEntity<String> AddCourseInSpecialization(@RequestHeader("Authorization") String token, @RequestBody @Valid SpecializationCourseRequest request) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token,email);

        return ResponseEntity.ok(specializationService.createCourse(request));
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<SpecializationWithCoursesResponse> getSpecializationWithCourses(
            @RequestHeader("Authorization") String token,
            @PathVariable String id) {
        // (Optional) Token validation logic here
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String email = jwtHelper.extractUsername(token);
        validateTokenForEmail(token, email);

        // Fetch specialization and associated courses
        return ResponseEntity.ok(specializationService.getSpecializationWithCourses(id));
    }

}
