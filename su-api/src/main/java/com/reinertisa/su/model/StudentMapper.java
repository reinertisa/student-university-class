package com.reinertisa.su.model;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentMapper implements Function<Student, StudentDto> {

    @Override
    public StudentDto apply(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .studentId(student.getStudentId())
                .build();
    }
}
