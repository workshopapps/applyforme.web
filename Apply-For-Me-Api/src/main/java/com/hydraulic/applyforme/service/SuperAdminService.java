package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.RecruiterCreateDto;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);
}
