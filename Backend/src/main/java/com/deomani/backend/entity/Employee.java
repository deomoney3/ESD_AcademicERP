package com.deomani.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name ="employee_id")
    private String employee_id;

    @Column(name ="First_name",nullable =false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="department" ,nullable=false)
    private String department;
}

