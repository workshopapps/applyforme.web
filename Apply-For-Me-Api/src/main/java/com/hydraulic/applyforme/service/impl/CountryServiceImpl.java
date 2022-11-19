package com.hydraulic.applyforme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.DeleteManyCountryDto;
import com.hydraulic.applyforme.model.dto.CountryDto;
import com.hydraulic.applyforme.model.exception.CounntryDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.CountryNotFoundException;
import com.hydraulic.applyforme.repository.CountryRepository;
import com.hydraulic.applyforme.repository.jpa.CountryJpaRepository;
import com.hydraulic.applyforme.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.readResourceFile;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryJpaRepository jpaRepository;

    public CountryServiceImpl(CountryRepository repository, CountryJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void seedCountryRecords() throws JsonProcessingException {

        String countriesJsonAsString = readResourceFile("json/countries.json");

        ObjectMapper mapper = new ObjectMapper();

        Country[] countriesArray = mapper.readValue(countriesJsonAsString, Country[].class);
        List<Country> countriesList = Arrays.asList(countriesArray);

        try {
            for (Country country : countriesList) {
                Optional<Country> countryExists = jpaRepository.findByTitleAndAbbreviation(country.getTitle(), country.getAbbreviation());

                if (countryExists.isPresent()) {
                    continue;
                }

                country.setId(null);
                repository.saveOne(country);
            }
        }
        catch (CounntryDuplicateEntityException exception) {
            /**
             * If a duplicate entry exists, it means we don't need to reinsert or save it as new row or entity in the database.
             * It means we will ignore.
             */
        }
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Country> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    public Country findOne(Long id) {
        Country country = repository.getOne(id);
        if (country == null) {
            throw new CountryNotFoundException(id);
        }
        return country;
    }

    @Override
    @Transactional
    public Country save(CountryDto body) {
        Country country = new Country();
        country = modelMapper.map(body, Country.class);
        return repository.updateOne(country);
    }

    @Override
    @Transactional
    public Country update(Long id, CountryDto body) {
        Country existingCountry = repository.getOne(id);
        if (existingCountry == null) {
            throw new CountryNotFoundException(id);
        }

        Country country = new Country();
        country = modelMapper.map(body, Country.class);
        country.setId(id);
        return repository.updateOne(country);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new CountryNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyCountryDto countryDto) {
        return repository.removeMany(countryDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
