package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import lombok.extern.slf4j.Slf4j;
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

<<<<<<< HEAD
        List<ApplierStatsDto> applierStatsDtos;
        List<Member> appliers = repository.getFiniteAppliers(pageOffset);
        if (appliers.isEmpty()) {
            return null;
        } else {
            applierStatsDtos = appliers.stream().map(applier -> mapper.map(applier, ApplierStatsDto.class))
                    .collect(Collectors.toList());
        }
        return applierStatsDtos;
=======
        var statistics = AdminDashboardStatisticsOne.builder()
                .totalApplications(totalApplications)
                .totalUsers(totalUsers)
                .build();
        return statistics;
>>>>>>> 832aac9cc504b87bcff33b458e6a5201fb05ff21
    }

    public List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions() {
        return repository.getAppliersTotalSubmissions();
    }
}
