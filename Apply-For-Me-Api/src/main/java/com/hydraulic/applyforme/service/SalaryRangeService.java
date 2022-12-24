package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.dto.salaryrange.DeleteManySalaryRangeDto;
import com.hydraulic.applyforme.model.dto.salaryrange.SalaryRangeDto;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;
import java.util.List;

public interface SalaryRangeService {

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    void seedSalaryRangeRecords() throws JsonProcessingException;

    List<SalaryRange> findAll(Integer pageOffset);

    List<SalaryRange> findAll();

    SalaryRange findOne(Long id);

    SalaryRange save(SalaryRangeDto body);

    SalaryRange update(Long id, SalaryRangeDto body);

    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManySalaryRangeDto manyDto);

    @Transactional
    boolean deleteAll();
}
