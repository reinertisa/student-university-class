package com.reinertisa.su.controller;

import com.reinertisa.su.model.UniversityClassDto;
import com.reinertisa.su.model.UniversityClassRequest;
import com.reinertisa.su.service.UniversityClassService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/universityClasses")
@CrossOrigin(origins = "*")
public class UniversityClassController {

    private final UniversityClassService universityClassService;

    public UniversityClassController(UniversityClassService universityClassService) {
        this.universityClassService = universityClassService;
    }

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
            UniversityClassDto universityClassDto = universityClassService
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
            UniversityClassDto universityClassDto = universityClassService
                    .updateUniversityClass(id, universityClassRequest);
            return ResponseEntity.status(HttpStatus.OK).body(universityClassDto);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(value = "/{uid}")
    public ResponseEntity<Void> deleteUniversityClass(@PathVariable("uid") Long id) {
        try {
            universityClassService.deleteUniversityClass(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }




}
