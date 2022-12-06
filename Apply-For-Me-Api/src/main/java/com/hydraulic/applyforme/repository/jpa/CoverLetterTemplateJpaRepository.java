package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoverLetterTemplateJpaRepository extends JpaRepository<CoverLetterTemplate, Long> {

    Optional<CoverLetterTemplate> findByTitle(String title);
}
