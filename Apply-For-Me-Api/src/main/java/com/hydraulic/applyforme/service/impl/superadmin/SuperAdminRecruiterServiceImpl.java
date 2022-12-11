package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.jpa.SuperAdminRecruiterJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminRecruiterServiceImpl implements SuperAdminRecruiterService {

    @Autowired
    private final SuperAdminApplicantService service;

    private final SuperAdminRecruiterJpaRepository repository;

    public SuperAdminRecruiterServiceImpl(SuperAdminApplicantService service, SuperAdminRecruiterJpaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public Member searchRecruitersByName(String firstName) {
        return repository.searchRecruiterByName(firstName);
    }
}

