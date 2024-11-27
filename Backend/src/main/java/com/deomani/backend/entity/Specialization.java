package com.deomani.backend.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @Column(name ="specialization_id")
    private String specialization_id;

    @Column(name ="code",nullable =false,unique = true)
    private String code;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name="year", nullable = false)
    private String year;

    @Column(name="credits_required" ,nullable=false)
    private String credits_required;
}
