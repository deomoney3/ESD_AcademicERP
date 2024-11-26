package com.deomani.backend.mapper;

import com.deomani.backend.dto.EmployeeRequest;
import com.deomani.backend.dto.EmployeeResponse;
import com.deomani.backend.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest request) {
        return Employee.builder()
                .employee_id(request.employee_id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .title(request.title())
                .department(request.department())
                .build();
    }

}
