package com.reinertisa.su.service;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.Student;
import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentMapper;
import com.reinertisa.su.model.StudentRequest;
import com.reinertisa.su.repository.StudentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper)
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");
        return studentRepository
                .findById(studentId)
                .map(studentMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));
    }

    @Override @Transactional
    public void createStudent(@Valid StudentRequest studentRequest) {
        studentRepository.save(
                Student.builder()
                        .name(studentRequest.getName())
                        .studentId(studentRequest.getStudentId())
                        .build());
    }

    @Override @Transactional
    public void updateStudent(Long studentId, @Valid StudentRequest studentRequest) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");
        Objects.requireNonNull(studentRequest, "Student request must not be null.");

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        Optional.ofNullable(studentRequest.getName())
                .ifPresent(student::setName);
        Optional.ofNullable(studentRequest.getStudentId())
                .ifPresent(student::setStudentId);

        studentRepository.save(student);

    }

    @Override @Transactional
    public void deleteStudent(Long studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        studentRepository.delete(student);
    }
}
