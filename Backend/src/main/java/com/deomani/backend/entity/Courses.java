package com.deomani.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @Column(name ="course_id")
    private String course_id;

    @Column(name ="course_code",nullable =false,unique = true)
    private String course_code;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name="year", nullable = false)
    private String year;

    @Column(name="term", nullable = false)
    private String term;

    @Column(name="faculty", nullable = false)
    private String faculty;

    @Column(name="credits" ,nullable=false)
    private String credits;

    @Column(name="capacity", nullable = false)
    private String capacity;
}
