package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.domain.Submission;

import java.util.List;

public interface ViewSubmissionRepository {

    List<Submission> getAll();

    List<Submission> getAll(Integer pageOffSet);

    Submission getOne(Long id);

    Submission saveOne(Submission submission);

    Submission updateOne(Submission submission);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}
