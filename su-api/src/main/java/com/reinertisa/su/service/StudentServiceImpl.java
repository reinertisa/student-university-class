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
    public StudentDto getStudentByStudentId(String studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");
        return studentRepository
                .findByStudentId(studentId)
                .map(studentMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));
    }

    @Override @Transactional
    public StudentDto createStudent(@Valid StudentRequest studentRequest) throws ResourceNotFoundException {
        Student student = Student.builder()
                .name(studentRequest.getName())
                .studentId(studentRequest.getStudentId())
                .universityClasses(studentRequest.getUniversityClasses())
                .build();
        studentRepository.save(student);

        return studentRepository
                .findById(student.getId())
                .map(studentMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentRequest.getStudentId()));
    }

    @Override @Transactional
    public void updateStudent(String studentId, @Valid StudentRequest studentRequest) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");
        Objects.requireNonNull(studentRequest, "Student request must not be null.");

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        Optional.ofNullable(studentRequest.getName())
                .ifPresent(student::setName);
        Optional.ofNullable(studentRequest.getStudentId())
                .ifPresent(student::setStudentId);

        studentRepository.save(student);

    }

    @Override @Transactional
    public void deleteStudent(String studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        studentRepository.delete(student);
    }
}
