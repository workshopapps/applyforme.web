package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.JobTitle;

import java.util.List;

public interface JobTitleRepository {

    List<JobTitle> getAll();
    List<JobTitle> getAll(Integer pageOffset);
    JobTitle getOne(Long id);
    JobTitle getRef(Long id);
    JobTitle saveOne(JobTitle country);
    JobTitle updateOne(JobTitle country);
    boolean remove(Long id);
    boolean removeMany(List<Long> ids);
    boolean removeAll();
}
