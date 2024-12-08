package com.reinertisa.su.service;

import com.reinertisa.su.exception.AlreadyExistsException;
import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByStudentId(String studentId) throws ResourceNotFoundException;

    StudentDto createStudent(@Valid StudentRequest studentRequest)
            throws ResourceNotFoundException, AlreadyExistsException;

    StudentDto updateStudent(String studentId, @Valid StudentRequest studentRequest)
            throws ResourceNotFoundException, AlreadyExistsException;

    void deleteStudent(String studentId) throws ResourceNotFoundException;
}
