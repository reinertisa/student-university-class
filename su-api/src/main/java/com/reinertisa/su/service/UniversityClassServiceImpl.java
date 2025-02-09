package com.reinertisa.su.service;

import com.reinertisa.su.exception.ResourceNotFoundException;
import com.reinertisa.su.model.UniversityClass;
import com.reinertisa.su.model.UniversityClassDto;
import com.reinertisa.su.model.UniversityClassMapper;
import com.reinertisa.su.model.UniversityClassRequest;
import com.reinertisa.su.repository.UniversityClassRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class UniversityClassServiceImpl implements UniversityClassService {

    private final UniversityClassRepository universityClassRepository;
    private final UniversityClassMapper universityClassMapper;

    public UniversityClassServiceImpl(UniversityClassRepository universityClassRepository,
                                      UniversityClassMapper universityClassMapper) {
        this.universityClassRepository = universityClassRepository;
        this.universityClassMapper = universityClassMapper;
    }

    @Override
    public List<UniversityClassDto> getAllUniversityClasses() {
        return universityClassMapper.toDtoListFromEntityList(universityClassRepository.findAll());
    }

    @Override
    public UniversityClassDto getUniversityClassById(Long universityClassId) throws ResourceNotFoundException {
        Objects.requireNonNull(universityClassId);

        return universityClassRepository.findById(universityClassId)
                .map(universityClassMapper::toDtoFromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("University class not found for this ID: " +
                        universityClassId));
    }

    @Override
    @Transactional
    public UniversityClassDto createUniversityClass(@Valid UniversityClassRequest universityClassRequest) {
        UniversityClass universityClass = universityClassMapper.toEntityFromRequest(universityClassRequest);
        return universityClassMapper.toDtoFromEntity(universityClassRepository.save(universityClass));
    }

    @Override
    @Transactional
    public UniversityClassDto updateUniversityClass(Long universityClassId, UniversityClassRequest universityClassRequest)
            throws ResourceNotFoundException {
        Objects.requireNonNull(universityClassId, "University class ID must not be null.");
        Objects.requireNonNull(universityClassRequest, "University class request must not be null.");

        validateUniversityClassRequest(universityClassRequest);

        UniversityClass universityClass = universityClassRepository.findById(universityClassId)
                .orElseThrow(() -> new ResourceNotFoundException("University class not found for this ID: " +
                        universityClassId));

        updateUniversityClassRequest(universityClass, universityClassRequest);

        return universityClassMapper.toDtoFromEntity(universityClassRepository.save(universityClass));
    }

    private void validateUniversityClassRequest(UniversityClassRequest universityClassRequest) {
        String name = Objects.requireNonNull(universityClassRequest.getUniversityClassName(),
                "Name must not be null.");
        String professor = Objects.requireNonNull(universityClassRequest.getProfessor(),
                "Professor must not be null.");

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }

        if (professor.isBlank()) {
            throw new IllegalArgumentException(("Professor must not be blank."));
        }
    }

    private void updateUniversityClassRequest(UniversityClass universityClass, UniversityClassRequest
            universityClassRequest) {
        updateIfNotNull(universityClassRequest::getUniversityClassName, universityClass::setName);
        updateIfNotNull(universityClassRequest::getProfessor, universityClass::setProfessor);
        updateIfNotNull(universityClassRequest::getCourseId, universityClass::setCourseId);
        updateIfNotNull(universityClassRequest::getDescription, universityClass::setDescription);

    }

    private <T> void updateIfNotNull(Supplier<T> valueSupplier, Consumer<T> valueConsumer) {
        Optional.ofNullable(valueSupplier.get())
                .ifPresent(valueConsumer);
    }

    @Override @Transactional
    public void deleteUniversityClass(Long universityClassId) throws ResourceNotFoundException {
        Objects.requireNonNull(universityClassId, "University class Id must not be null");

        UniversityClass universityClass = universityClassRepository.findById(universityClassId)
                .orElseThrow(() -> new ResourceNotFoundException("University class not found for this ID: " +
                        universityClassId));
        universityClassRepository.delete(universityClass);
    }
}
