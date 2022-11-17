package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.ApplicationSubmissionsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationSubmissionsRepoImpl implements ApplicationSubmissionsRepository {
    @Override
    public Page<Submission> getAllSubmissions(List<Submission> submissions, Pageable pageable) {
        return null;
    }
}
