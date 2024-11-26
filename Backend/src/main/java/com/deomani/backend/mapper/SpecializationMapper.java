package com.deomani.backend.mapper;

import com.deomani.backend.dto.SpecializationRequest;
import com.deomani.backend.dto.SpecializationResponse;
import com.deomani.backend.entity.Specialization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationMapper {
    public  Specialization toEntity(SpecializationRequest request) {
        return Specialization.builder()
                .specialization_id(request.specialization_id())
                .code(request.code())
                .name(request.name())
                .description(request.description())
                .year(request.year())
                .credits_required(request.credits_required())
                .build();
    }

    public static SpecializationResponse toSpecializationResponse(Specialization specialization) {

        return new SpecializationResponse(
                specialization.getSpecialization_id(),
                specialization.getCode(),
                specialization.getName(),
                specialization.getDescription(),
                specialization.getYear(),
                specialization.getCredits_required()
        );
    }

}
