package com.reinertisa.su.repository;

import com.reinertisa.su.model.UniversityClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityClassRepository extends JpaRepository<UniversityClass, Long> {
}
