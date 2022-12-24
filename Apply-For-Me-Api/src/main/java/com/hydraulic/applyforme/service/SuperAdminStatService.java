package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;

import java.util.Date;
import java.util.List;

public interface SuperAdminStatService {
    AdminDashboardStatisticsOne getStatistics(Date from, Date to);
    List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions(Integer pageOffset);
}