package com.reinertisa.su.service;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentRequest;

public class StudentServiceImpl implements StudentService {

    @Override
    public StudentDto getAllStudents() {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long studentId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void createStudent(StudentRequest studentRequest) {

    }

    @Override
    public void updateStudent(Long studentId, StudentRequest studentRequest) throws ResourceNotFoundException {

    }

    @Override
    public void deleteStudent(Long studentId) throws ResourceNotFoundException {

    }
}
