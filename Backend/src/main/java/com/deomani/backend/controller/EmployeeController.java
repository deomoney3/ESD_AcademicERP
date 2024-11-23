package com.deomani.backend.controller;

import com.deomani.backend.dto.EmployeeRequest;
import com.deomani.backend.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }
}