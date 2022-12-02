package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.exception.DateInvalidException;
import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import com.hydraulic.applyforme.validator.DateValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class SuperAdminStatServiceImpl implements SuperAdminStatService {
    private final SuperAdminStatRepository repository;

    private final DateValidator dateValidator;

    public SuperAdminStatServiceImpl(SuperAdminStatRepository repository, DateValidator dateValidator) {
        this.repository = repository;
        this.dateValidator = dateValidator;
    }
    @Override
    @Transactional(readOnly = true)
    public AdminDashboardStatisticsOne getStatistics(String date) {

        boolean valid = dateValidator.isValid(date);
        if (valid == Boolean.FALSE){
            throw new DateInvalidException(date);
        }
        Long totalApplications = repository.getAllSubmissions(dateValidator.startDateFormat(date), dateValidator.endDateFormat(date));
        Long totalUsers = repository.getAllUsers();

        var statistics = AdminDashboardStatisticsOne.builder()
                .totalApplications(totalApplications)
                .totalUsers(totalUsers)
                .build();
        return statistics;
    }

    @Transactional(readOnly = true)
    public List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions(String date) {
        if (dateValidator.isValid(date) == Boolean.FALSE){
            throw new DateInvalidException(date);
        }
        return repository.getAppliersTotalSubmissions(dateValidator.startDateFormat(date), dateValidator.endDateFormat(date));
    }
}
