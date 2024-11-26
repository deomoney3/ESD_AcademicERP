package com.deomani.backend.controller;

import com.deomani.backend.dto.SpecializationRequest;
import com.deomani.backend.dto.SpecializationResponse;
import com.deomani.backend.entity.Specialization;
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

    @PostMapping()
    public ResponseEntity<String> createSpecialization(@RequestBody @Valid SpecializationRequest request) {
        return ResponseEntity.ok(specializationService.createSpecialization(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@RequestBody SpecializationRequest request, @PathVariable String id) {
        return ResponseEntity.ok(specializationService.updateSpecialization(request,id));
    }

    @GetMapping()
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        return ResponseEntity.ok(specializationService.getAllSpecialization());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationResponse> getSpecializationById(@PathVariable String id) {

        SpecializationResponse specialization = specializationService.getSpecializationById(id);
        return ResponseEntity.ok(specialization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecializationById(@PathVariable String id) {
        specializationService.deleteSpecializationById(id);
        return ResponseEntity.ok("Specialization deleted successfully");
    }

}
