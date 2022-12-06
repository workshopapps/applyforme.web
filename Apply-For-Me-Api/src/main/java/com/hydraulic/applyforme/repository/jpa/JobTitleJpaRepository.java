package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobTitleJpaRepository extends JpaRepository<JobTitle, Long> {

    Optional<JobTitle> findByTitle(String title);
}
