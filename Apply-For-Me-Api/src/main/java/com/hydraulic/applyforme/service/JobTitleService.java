package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.JobTitle;
import com.hydraulic.applyforme.model.dto.jobtitle.DeleteManyJobTitleDto;
import com.hydraulic.applyforme.model.dto.jobtitle.JobTitleDto;

import javax.transaction.Transactional;
import java.util.List;

public interface JobTitleService {

    void seedJobTitleRecords() throws JsonProcessingException;

    List<JobTitle> findAll(Integer pageOffset);

    List<JobTitle> findAll();

    JobTitle findOne(Long id);

    @Transactional
    JobTitle save(JobTitleDto body);

    @Transactional
    JobTitle update(Long id, JobTitleDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyJobTitleDto countryDto);

    @Transactional
    boolean deleteAll();
}
