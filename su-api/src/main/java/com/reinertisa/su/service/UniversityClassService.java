package com.reinertisa.su.service;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.UniversityClassDto;
import com.reinertisa.su.model.UniversityClassRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface UniversityClassService {

    List<UniversityClassDto> getAllUniversityClasses();

    UniversityClassDto getUniversityClassById(Long universityClassId) throws ResourceNotFoundException;

    void createUniversityClass(@Valid UniversityClassRequest universityClassRequest);

    void updateUniversityClass(Long universityClassId, @Valid UniversityClassRequest universityClassRequest)
            throws ResourceNotFoundException;

    void deleteUniversityClass(Long universityClassId) throws ResourceNotFoundException;
}
