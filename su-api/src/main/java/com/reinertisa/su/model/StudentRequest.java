package com.reinertisa.su.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Builder
public class StudentRequest {

    @NotBlank(message = "This field is required.")
    private String name;

    @NotBlank(message = "This field is required.")
    private String studentId;

    @Email(message = "Please enter a valid email.")
    private String email;

    private Set<UniversityClass> universityClasses;
}

