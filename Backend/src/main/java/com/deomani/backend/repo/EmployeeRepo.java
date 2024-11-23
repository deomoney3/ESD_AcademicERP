package com.deomani.backend.repo;

import com.deomani.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail (String email);
}
