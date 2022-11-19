package com.hydraulic.applyforme.superadmin.repository;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Submission;

import java.util.List;

public interface SuperAdminStatsRepository {

    Long getAllSubmissions();

    Long getAllUsers();
}
