package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;

import java.util.List;

public interface CoverLetterTemplateRepository {

    List<CoverLetterTemplate> getAll();
    List<CoverLetterTemplate> getAll(Integer pageOffset);
    CoverLetterTemplate getOne(Long id);
    CoverLetterTemplate getRef(Long id);
    CoverLetterTemplate saveOne(CoverLetterTemplate country);
    CoverLetterTemplate updateOne(CoverLetterTemplate country);
    boolean remove(Long id);
    boolean removeMany(List<Long> ids);
    boolean removeAll();
}
