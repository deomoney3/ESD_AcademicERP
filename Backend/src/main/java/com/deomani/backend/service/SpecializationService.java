package com.deomani.backend.service;
import com.deomani.backend.dto.SpecializationRequest;
import com.deomani.backend.dto.SpecializationResponse;
import com.deomani.backend.entity.Specialization;
import com.deomani.backend.mapper.SpecializationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.deomani.backend.repo.SpecializationRepo;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationService {
    private final SpecializationRepo repo;
    private final SpecializationMapper mapper;
    private final SpecializationRepo specializationRepo;

    public String createSpecialization(SpecializationRequest request) {
        Specialization specialization = mapper.toEntity(request);
        repo.save(specialization);
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

}
