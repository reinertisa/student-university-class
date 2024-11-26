package com.reinertisa.su.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public class StudentRequest {

    @NotBlank(message = "This field is required.")
    private String name;
    @NotNull(message = "This field is required.")
    private Integer studentId;

}
