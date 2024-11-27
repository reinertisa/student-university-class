package com.reinertisa.su.controller;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.StudentDto;
import com.reinertisa.su.model.StudentRequest;
import com.reinertisa.su.service.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        try {
            return ResponseEntity.ok().body(studentServiceImpl.getAllStudents());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{sid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "sid") String studentId) {
        try {
            return ResponseEntity.ok().body(studentServiceImpl.getStudentByStudentId(studentId));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        try {
            studentServiceImpl.createStudent(studentRequest);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PutMapping(value = "/{sid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable(name = "sid") String studentId, @RequestBody @Valid StudentRequest studentRequest) {
        try {
            studentServiceImpl.updateStudent(studentId, studentRequest);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(value = "/{sid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable(value = "sid") String studentId) {
        try {
            studentServiceImpl.deleteStudent(studentId);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
