package com.reinertisa.su.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class StudentRequest {

    @NotBlank(message = "This field is required.")
    private String name;
    @NotBlank(message = "This field is required.")
    private String studentId;

}
