package com.hydraulic.applyforme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.dto.salaryrange.DeleteManySalaryRangeDto;
import com.hydraulic.applyforme.model.dto.salaryrange.SalaryRangeDto;
import com.hydraulic.applyforme.model.exception.SalaryRangeDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.SalaryRangeNotFoundException;
import com.hydraulic.applyforme.repository.SalaryRangeRepository;
import com.hydraulic.applyforme.repository.jpa.SalaryRangeJpaRepository;
import com.hydraulic.applyforme.service.SalaryRangeService;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class SalaryRangeServiceImpl implements SalaryRangeService {

    @Autowired
    private ModelMapper modelMapper;
    private final SalaryRangeRepository repository;
    private final SalaryRangeJpaRepository jpaRepository;

    public SalaryRangeServiceImpl(SalaryRangeRepository repository, SalaryRangeJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void seedSalaryRangeRecords() throws JsonProcessingException {

        String salaryRangeJsonAsString = readResourceFile("json/salaries.json");

        ObjectMapper mapper = new ObjectMapper();

        SalaryRange[] countriesArray = mapper.readValue(salaryRangeJsonAsString, SalaryRange[].class);
        List<SalaryRange> salaryRangesList = Arrays.asList(countriesArray);

        try {
            for (SalaryRange salaryRange : salaryRangesList) {
                Optional<SalaryRange> salaryRangeExists = jpaRepository.findBySalaryRange(salaryRange.getSalaryRange());

                if (salaryRangeExists.isPresent()) {
                    continue;
                }

                salaryRange.setId(null);
                repository.saveOne(salaryRange);
            }
        }
        catch (SalaryRangeDuplicateEntityException exception) {
            /**
             * If a duplicate entry exists, it means we don't need to reinsert or save it as new row or entity in the database.
             * It means we will ignore.
             */
        }
    }

    @Override
    public List<SalaryRange> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    public SalaryRange findOne(Long id) {
        SalaryRange salaryRange = repository.getOne(id);
        if (salaryRange == null) {
            throw new SalaryRangeNotFoundException(id);
        }
        return salaryRange;
    }

    @Override
    @Transactional
    public SalaryRange save(SalaryRangeDto body) {
        SalaryRange salaryRange = new SalaryRange();
        salaryRange = modelMapper.map(body, SalaryRange.class);
        return repository.updateOne(salaryRange);
    }

    @Override
    @Transactional
    public SalaryRange update(Long id, SalaryRangeDto body) {
        SalaryRange existingSalaryRange = repository.getOne(id);
        if (existingSalaryRange == null) {
            throw new SalaryRangeNotFoundException(id);
        }

        SalaryRange salaryRange = new SalaryRange();
        salaryRange = modelMapper.map(body, SalaryRange.class);
        salaryRange.setId(id);
        return repository.updateOne(salaryRange);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new SalaryRangeNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManySalaryRangeDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
    
}
