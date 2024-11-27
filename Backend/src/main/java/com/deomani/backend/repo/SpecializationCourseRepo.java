package com.deomani.backend.repo;

import com.deomani.backend.entity.SpecializationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SpecializationCourseRepo extends JpaRepository<SpecializationCourse, String> {
    @Query("SELECT s from SpecializationCourse s WHERE s.specialization_id = :specializationId")
    List<SpecializationCourse> findBySpecializationId(String specializationId);

    @Modifying
    @Transactional
    @Query("DELETE FROM SpecializationCourse s WHERE s.specialization_id = :id")
    void deleteById(@Param("id") String id);
}
