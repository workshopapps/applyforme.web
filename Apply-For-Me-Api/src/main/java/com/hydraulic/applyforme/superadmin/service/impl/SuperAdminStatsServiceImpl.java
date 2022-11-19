package com.hydraulic.applyforme.superadmin.service.impl;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.superadmin.repository.SuperAdminStatsRepository;
import com.hydraulic.applyforme.superadmin.service.SuperAdminStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SuperAdminStatsServiceImpl implements SuperAdminStatsService {


    final private SuperAdminStatsRepository superAdminStatsRepository;

    @Override
    public Long getTotalApplications() {
        return superAdminStatsRepository.getAllSubmissions();
    }

    @Override
    public Long getTotalUsers() {
        log.info("Inside total users");
        return superAdminStatsRepository.getAllUsers();
    }

}
