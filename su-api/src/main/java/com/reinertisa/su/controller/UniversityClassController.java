package com.reinertisa.su.controller;

import com.reinertisa.su.exception.ResourceNotFoundException;
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
@RequestMapping(value = "/api/v1/universityClass")
public class UniversityClassController {

    private final UniversityClassServiceImpl universityClassService;
    private final UniversityClassServiceImpl universityClassServiceImpl;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UniversityClassDto>> getAllUniversityClasses() {
        try {
            return ResponseEntity.ok().body(universityClassService.getAllUniversityClasses());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{uid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UniversityClassDto> getUniversityById(@PathVariable("uid") Long id) {
        try {
            return ResponseEntity.ok().body(universityClassService.getUniversityClassById(id));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUniversityClass(@Valid @RequestBody UniversityClassRequest universityClassRequest) {
        try {
            universityClassServiceImpl.createUniversityClass(universityClassRequest);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PutMapping(value = "/{uid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUniversityClass(@PathVariable(name = "uid") Long id,
                                      @Valid @RequestBody UniversityClassRequest universityClassRequest) {
        try {
            universityClassServiceImpl.updateUniversityClass(id, universityClassRequest);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(value = "/{uid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUniversityClass(@PathVariable("uid") Long id) {
        try {
            universityClassServiceImpl.deleteUniversityClass(id);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }




}
