package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;

import java.util.List;

public interface SuperAdminStatService {
    AdminDashboardStatisticsOne getStatistics();
    List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions();
}