package com.deomani.backend.service;

import com.deomani.backend.dto.EmployeeRequest;
import com.deomani.backend.dto.LoginRequest;
import com.deomani.backend.entity.Employee;
import com.deomani.backend.helper.JWTHelper;
import com.deomani.backend.mapper.EmployeeMapper;
import com.deomani.backend.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.deomani.backend.helper.EncryptionService;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo repo;
    private final EmployeeMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    public String createEmployee(EmployeeRequest request) {
        Employee employee = mapper.toEntity(request);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        repo.save(employee);
        return "Employee Created Successfully";
    }

    public String login(LoginRequest request) {
        Employee employee = repo.findByEmail(request.email());
        if(!(request.password().equals(employee.getPassword()) && employee.getDepartment().equals("Admin"))) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }
}