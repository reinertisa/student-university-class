package com.reinertisa.su.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "universityClasses")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer courseId;

    @Column(nullable = false)
    private String professor;

    @Column(nullable = false)
    private String description;

    @JsonManagedReference
    @ManyToMany(mappedBy = "universityClasses", fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

}
