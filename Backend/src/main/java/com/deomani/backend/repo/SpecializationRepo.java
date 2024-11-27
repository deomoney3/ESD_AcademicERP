package com.deomani.backend.repo;

import com.deomani.backend.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpecializationRepo extends JpaRepository<Specialization, String> {

}
