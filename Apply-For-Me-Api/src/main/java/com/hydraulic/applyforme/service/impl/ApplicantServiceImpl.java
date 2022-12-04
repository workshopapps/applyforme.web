package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.ApplicantRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository repository;

    public ApplicantServiceImpl(ApplicantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member getDetails(Long id) {
        return repository.getMyDetailsById(id);
    }
}
