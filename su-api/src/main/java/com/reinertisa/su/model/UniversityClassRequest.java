package com.reinertisa.su.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UniversityClassRequest {

    @NotBlank(message = "This field is required.")
    private String name;

    @NotNull(message = "This field is required.")
    private Integer courseId;

    @NotBlank(message = "This field is required.")
    private String professor;

    @NotBlank(message = "This field is required.")
    private String description;
}
