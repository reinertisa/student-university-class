package com.reinertisa.su.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String studentId;
    private Set<UniversityClass> universityClasses;
}
