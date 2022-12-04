package com.hydraulic.applyforme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.JobTitle;
import com.hydraulic.applyforme.model.dto.jobtitle.DeleteManyJobTitleDto;
import com.hydraulic.applyforme.model.dto.jobtitle.JobTitleDto;
import com.hydraulic.applyforme.model.exception.JobTitleDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.JobTitleNotFoundException;
import com.hydraulic.applyforme.repository.JobTitleRepository;
import com.hydraulic.applyforme.repository.jpa.JobTitleJpaRepository;
import com.hydraulic.applyforme.service.JobTitleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.readResourceFile;

@Service
public class JobTitleServiceImpl implements JobTitleService {


    private final JobTitleRepository repository;
    private final JobTitleJpaRepository jpaRepository;

    public JobTitleServiceImpl(JobTitleRepository repository, JobTitleJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void seedJobTitleRecords() throws JsonProcessingException {

        String jobTitlesJsonAsString = readResourceFile("json/job-titles.json");

        ObjectMapper mapper = new ObjectMapper();

        JobTitle[] jobTitlesArray = mapper.readValue(jobTitlesJsonAsString, JobTitle[].class);
        List<JobTitle> jobTitlesList = Arrays.asList(jobTitlesArray);

        try {
            for (JobTitle jobTitle : jobTitlesList) {
                if (false) {
                    Optional<JobTitle> jobTitleExists = jpaRepository.findByTitle(jobTitle.getTitle());

                    if (jobTitleExists.isPresent()) {
                        continue;
                    }

                    jobTitle.setId(null);
                    repository.saveOne(jobTitle);
                }
            }
        }
        catch (JobTitleDuplicateEntityException exception) {
            /**
             * If a duplicate entry exists, it means we don't need to reinsert or save it as new row or entity in the database.
             * It means we will ignore.
             */
        }
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<JobTitle> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobTitle> findAll() {
        return repository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public JobTitle findOne(Long id) {
        JobTitle jobTitle = repository.getOne(id);
        if (jobTitle == null) {
            throw new JobTitleNotFoundException(id);
        }
        return jobTitle;
    }

    @Override
    @Transactional
    public JobTitle save(JobTitleDto body) {
        JobTitle jobTitle = new JobTitle();
        jobTitle = modelMapper.map(body, JobTitle.class);
        return repository.updateOne(jobTitle);
    }

    @Override
    @Transactional
    public JobTitle update(Long id, JobTitleDto body) {
        JobTitle existingJobTitle = repository.getOne(id);
        if (existingJobTitle == null) {
            throw new JobTitleNotFoundException(id);
        }

        JobTitle jobTitle = new JobTitle();
        jobTitle = modelMapper.map(body, JobTitle.class);
        jobTitle.setId(id);
        return repository.updateOne(jobTitle);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new JobTitleNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyJobTitleDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }

}
