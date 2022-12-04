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
        Long totalUsers = repository.getAllUsers(dateValidator.startDateFormat(date), dateValidator.endDateFormat(date));
        Long totalRRAdmins = repository.getRRAdmins(dateValidator.startDateFormat(date), dateValidator.endDateFormat(date));

        return AdminDashboardStatisticsOne.builder()
                .totalApplications(totalApplications)
                .totalUsers(totalUsers)
                .totalRRAdmins(totalRRAdmins)
                .build();
    }

    @Transactional(readOnly = true)
    public List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions(Integer pageNumber) {
        return repository.getAppliersTotalSubmissions(pageNumber);
    }
}
