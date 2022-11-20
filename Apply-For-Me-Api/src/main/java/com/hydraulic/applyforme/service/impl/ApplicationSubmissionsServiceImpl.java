package com.hydraulic.applyforme.service.impl;


import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.ApplicationSubmissionsRepository;
import com.hydraulic.applyforme.service.ApplicationSubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ApplicationSubmissionsServiceImpl implements ApplicationSubmissionsService {
    private final ApplicationSubmissionsRepository applicationSubmissionsRepository;

    @Override
    public Collection<Submission> getAllApplicationSubmissions() {
        Collection<Submission> submissions = applicationSubmissionsRepository.findAll();
        return submissions;

    }
}
