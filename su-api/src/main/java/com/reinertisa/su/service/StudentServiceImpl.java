package com.reinertisa.su.service;

import com.reinertisa.su.exception.AlreadyExistsException;
import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.*;
import com.reinertisa.su.repository.StudentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentMapper.toDtoListFromEntityList(studentRepository.findAll());
    }

    @Override
    public StudentDto getStudentByStudentId(String studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");

        return studentRepository
                .findByStudentId(studentId)
                .map(studentMapper::toDtoFromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));
    }

    @Override
    @Transactional
    public StudentDto createStudent(@Valid StudentRequest studentRequest) throws AlreadyExistsException {
        Optional<Student> existStudent = studentRepository.findByStudentId(studentRequest.getStudentId());
        if (existStudent.isPresent()) {
            throw new AlreadyExistsException(String.format("This student id %s already exists.",
                    existStudent.get().getStudentId()), "studentId");
        }

        existStudent = studentRepository.findByEmail(studentRequest.getStudentEmail());
        if (existStudent.isPresent()) {
            throw new AlreadyExistsException(String.format("This email %s already exists.",
                    existStudent.get().getEmail()), "email");
        }

        Student student = studentMapper.toEntityFromRequest(studentRequest);
        return studentMapper.toDtoFromEntity(studentRepository.save(student));
    }

    @Override @Transactional
    public StudentDto updateStudent(String studentId, @Valid StudentRequest studentRequest)
            throws ResourceNotFoundException, AlreadyExistsException {
        Objects.requireNonNull(studentId, "This field is required.");
        Objects.requireNonNull(studentRequest, "Student request must not be null.");

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        if (!student.getEmail().equals(studentRequest.getStudentEmail())) {
            Optional<Student> existStudent = studentRepository.findByEmail(studentRequest.getStudentEmail());
            if (existStudent.isPresent()) {
                throw new AlreadyExistsException(String.format("This email %s used. Please use different email",
                        existStudent.get().getEmail()), "email");
            }
        }

        Optional.ofNullable(studentRequest.getStudentName())
                .ifPresent(student::setName);
        Optional.ofNullable(studentRequest.getStudentId())
                .ifPresent(student::setStudentId);

        return studentMapper.toDtoFromEntity(studentRepository.save(student));
    }

    @Override @Transactional
    public void deleteStudent(String studentId) throws ResourceNotFoundException {
        Objects.requireNonNull(studentId, "This field is required.");

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + studentId));

        studentRepository.delete(student);
    }
}
