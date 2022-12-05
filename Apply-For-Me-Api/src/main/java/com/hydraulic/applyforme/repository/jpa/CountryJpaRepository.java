package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryJpaRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByTitleAndAbbreviation(String title, String abbreviation);
}
