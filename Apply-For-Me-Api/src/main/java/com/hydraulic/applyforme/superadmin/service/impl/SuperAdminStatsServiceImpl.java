package com.hydraulic.applyforme.superadmin.service.impl;

import com.hydraulic.applyforme.superadmin.repository.SuperAdminStatsRepository;
import com.hydraulic.applyforme.superadmin.service.SuperAdminStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SuperAdminStatsServiceImpl implements SuperAdminStatsService {


    private final SuperAdminStatsRepository repository;

    public SuperAdminStatsServiceImpl(SuperAdminStatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long getTotalApplications() {
        return repository.getAllSubmissions();
    }

    @Override
    public Long getTotalUsers() {
        log.info("Inside total users");
        return repository.getAllUsers();
    }

}
