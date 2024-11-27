package com.deomani.backend.repo;

import com.deomani.backend.entity.Courses;
import com.deomani.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepo extends JpaRepository<Courses, String> {

}
