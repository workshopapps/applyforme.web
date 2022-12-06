package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.CoverLetterTemplateDto;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.DeleteManyCoverLetterTemplateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CoverLetterService {
    void seedCoverLetterTemplateRecords() throws JsonProcessingException;

    List<CoverLetterTemplate> findAll(Integer pageOffset);

    List<CoverLetterTemplate> findAll();

    CoverLetterTemplate findOne(Long id);

    @Transactional
    CoverLetterTemplate save(CoverLetterTemplateDto body);

    @Transactional
    CoverLetterTemplate update(Long id, CoverLetterTemplateDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyCoverLetterTemplateDto countryDto);

    @Transactional
    boolean deleteAll();
}
