package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;

import java.util.Optional;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Optional<Member> getAdmin(Long id);
}
