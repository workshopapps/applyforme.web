package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SuperAdminStatServiceImpl implements SuperAdminStatService {
    private final SuperAdminStatRepository repository;
    private final ModelMapper mapper;

    public SuperAdminStatServiceImpl(SuperAdminStatRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public AdminDashboardStatisticsOne getStatistics() {

        Long totalApplications = repository.getAllSubmissions();
        Long totalUsers = repository.getAllUsers();

        var statistics = AdminDashboardStatisticsOne.builder()
                .totalApplications(totalApplications)
                .totalUsers(totalUsers)
                .build();
        return statistics;
    }

    public List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions() {
        return repository.getAppliersTotalSubmissions();
    }
}