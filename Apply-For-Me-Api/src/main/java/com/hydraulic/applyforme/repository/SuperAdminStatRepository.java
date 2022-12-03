package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.validator.DateValidator;

import java.util.Date;
import java.util.List;

public interface SuperAdminStatRepository {

    Long getAllSubmissions(Date startDate, Date endDate);

    Long getAllUsers(Date startDate, Date endDate);

    Long getRRAdmins(Date startDate, Date endDate);

    List<ApplierJobSubmissionStatistics> getAppliersTotalSubmissions(Integer pageNumber);
}