package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.DeleteManyCountryDto;
import com.hydraulic.applyforme.model.dto.CountryDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CountryService {

    void seedCountryRecords() throws JsonProcessingException;

    List<Country> findAll(Integer pageOffset);

    Country findOne(Long id);

    @Transactional
    Country save(CountryDto body);

    @Transactional
    Country update(Long id, CountryDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyCountryDto countryDto);

    @Transactional
    boolean deleteAll();
}
