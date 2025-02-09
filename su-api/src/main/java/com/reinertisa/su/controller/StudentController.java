package com.reinertisa.su.controller;

import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentRequest;
import com.reinertisa.su.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") String studentId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByStudentId(studentId));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequest));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") String studentId,
                                              @RequestBody @Valid StudentRequest studentRequest) {
        try {
            StudentDto student = studentService.updateStudent(studentId, studentRequest);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") String studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
