package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SuperAdminStatServiceImpl implements SuperAdminStatService {


    private final SuperAdminStatRepository repository;

    public SuperAdminStatServiceImpl(SuperAdminStatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long getTotalApplications() {
        return repository.getAllSubmissions();
    }

    @Override
    public Long getTotalUsers() {
        return repository.getAllUsers();
    }

}
