package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;

import java.util.List;

public interface SubmissionRepository {



    List<Submission> getAll(Integer pageOffSet);
}
