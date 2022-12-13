package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Submission;

public interface SubmissionRepository {

    Submission saveOne(Submission submission);
}
