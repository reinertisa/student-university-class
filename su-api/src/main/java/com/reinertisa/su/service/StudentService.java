package com.reinertisa.su.service;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByStudentId(String studentId) throws ResourceNotFoundException;

    void createStudent(@Valid StudentRequest studentRequest);

    void updateStudent(String studentId, @Valid StudentRequest studentRequest) throws ResourceNotFoundException;

    void deleteStudent(String studentId) throws ResourceNotFoundException;
}
