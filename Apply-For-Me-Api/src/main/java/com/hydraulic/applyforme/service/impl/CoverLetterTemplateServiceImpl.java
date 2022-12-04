package com.hydraulic.applyforme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.CoverLetterTemplateDto;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.DeleteManyCoverLetterTemplateDto;
import com.hydraulic.applyforme.model.exception.CoverLetterTemplateDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.CoverLetterTemplateNotFoundException;
import com.hydraulic.applyforme.repository.CoverLetterTemplateRepository;
import com.hydraulic.applyforme.repository.jpa.CoverLetterTemplateJpaRepository;
import com.hydraulic.applyforme.service.CoverLetterService;
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
public class CoverLetterTemplateServiceImpl implements CoverLetterService {


    private final CoverLetterTemplateRepository repository;
    private final CoverLetterTemplateJpaRepository jpaRepository;

    public CoverLetterTemplateServiceImpl(CoverLetterTemplateRepository repository, CoverLetterTemplateJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void seedCoverLetterTemplateRecords() throws JsonProcessingException {

        String coverLetterTemplatesJsonAsString = readResourceFile("json/cover-letter-templates.json");

        ObjectMapper mapper = new ObjectMapper();

        CoverLetterTemplate[] coverLetterTemplatesArray = mapper.readValue(coverLetterTemplatesJsonAsString, CoverLetterTemplate[].class);
        List<CoverLetterTemplate> coverLetterTemplatesList = Arrays.asList(coverLetterTemplatesArray);

        try {
            for (CoverLetterTemplate coverLetterTemplate : coverLetterTemplatesList) {
                if (false) {
                    Optional<CoverLetterTemplate> coverLetterTemplateExists = jpaRepository.findByTitle(coverLetterTemplate.getTitle());

                    if (coverLetterTemplateExists.isPresent()) {
                        continue;
                    }

                    coverLetterTemplate.setId(null);
                    repository.saveOne(coverLetterTemplate);
                }
            }
        }
        catch (CoverLetterTemplateDuplicateEntityException exception) {
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
    public List<CoverLetterTemplate> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoverLetterTemplate> findAll() {
        return repository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CoverLetterTemplate findOne(Long id) {
        CoverLetterTemplate coverLetterTemplate = repository.getOne(id);
        if (coverLetterTemplate == null) {
            throw new CoverLetterTemplateNotFoundException(id);
        }
        return coverLetterTemplate;
    }

    @Override
    @Transactional
    public CoverLetterTemplate save(CoverLetterTemplateDto body) {
        CoverLetterTemplate coverLetterTemplate = new CoverLetterTemplate();
        coverLetterTemplate = modelMapper.map(body, CoverLetterTemplate.class);
        return repository.updateOne(coverLetterTemplate);
    }

    @Override
    @Transactional
    public CoverLetterTemplate update(Long id, CoverLetterTemplateDto body) {
        CoverLetterTemplate existingCoverLetterTemplate = repository.getOne(id);
        if (existingCoverLetterTemplate == null) {
            throw new CoverLetterTemplateNotFoundException(id);
        }

        CoverLetterTemplate coverLetterTemplate = new CoverLetterTemplate();
        coverLetterTemplate = modelMapper.map(body, CoverLetterTemplate.class);
        coverLetterTemplate.setId(id);
        return repository.updateOne(coverLetterTemplate);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new CoverLetterTemplateNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyCoverLetterTemplateDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
