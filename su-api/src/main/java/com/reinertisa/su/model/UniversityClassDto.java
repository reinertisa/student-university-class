package com.reinertisa.su.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UniversityClassDto {
    private Long id;
    private String name;
    private Integer courseId;
    private String professor;
    private String description;
}
