package com.deomani.backend.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CourseSpecialization")
public class CourseSpecialization {
    @Id
    @Column(name ="course_id")
    private String course_id;

    @Column(name ="course_code",nullable =false)
    private String course_code;

    @Column(name = "name")
    private String name;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name="year", nullable = false)
    private String year;

    @Column(name="term", nullable = false)
    private String term;

    @Column(name="faculty" ,nullable=false)
    private String faculty;

    @Column(name="credits" ,nullable=false)
    private String credits;

    @Column(name="capacity" ,nullable=false)
    private String capacity;
}
