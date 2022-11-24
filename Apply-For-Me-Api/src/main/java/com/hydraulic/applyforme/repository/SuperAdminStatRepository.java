package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;

import java.util.List;

public interface SuperAdminStatRepository {

    Long getAllSubmissions();

    Long getAllUsers();

    List<Member> getFiniteAppliers(Integer pageOffset);
}