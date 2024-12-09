package com.reinertisa.su.controller;

import com.reinertisa.su.model.UniversityClassDto;
import com.reinertisa.su.model.UniversityClassRequest;
import com.reinertisa.su.service.UniversityClassServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/universityClasses")
public class UniversityClassController {

    private final UniversityClassServiceImpl universityClassService;
    private final UniversityClassServiceImpl universityClassServiceImpl;

    @GetMapping
    public ResponseEntity<List<UniversityClassDto>> getAllUniversityClasses() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(universityClassService.getAllUniversityClasses());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityClassDto> getUniversityById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(universityClassService.getUniversityClassById(id));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping
    public ResponseEntity<UniversityClassDto> createUniversityClass(
            @Valid @RequestBody UniversityClassRequest universityClassRequest) {
        try {
            UniversityClassDto universityClassDto = universityClassServiceImpl
                    .createUniversityClass(universityClassRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(universityClassDto);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityClassDto> updateUniversityClass(@PathVariable(name = "id") Long id,
                                            @Valid @RequestBody UniversityClassRequest universityClassRequest) {
        try {
            UniversityClassDto universityClassDto = universityClassServiceImpl
                    .updateUniversityClass(id, universityClassRequest);
            return ResponseEntity.status(HttpStatus.OK).body(universityClassDto);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(value = "/{uid}")
    public ResponseEntity<Void> deleteUniversityClass(@PathVariable("uid") Long id) {
        try {
            universityClassServiceImpl.deleteUniversityClass(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }




}
