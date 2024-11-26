package com.reinertisa.su.model;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityClassMapper implements Function<UniversityClass, UniversityClassDto> {

    @Override
    public UniversityClassDto apply(UniversityClass universityClass) {
        return UniversityClassDto.builder()
                .id(universityClass.getId())
                .name(universityClass.getName())
                .professor(universityClass.getProfessor())
                .description(universityClass.getDescription())
                .courseId(universityClass.getCourseId())
                .build();
    }

}
