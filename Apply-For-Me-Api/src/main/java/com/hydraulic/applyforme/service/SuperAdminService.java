package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);

//    Member createRecruiter(MemberDto memberDto);
    Member updatePassword(Long id, UpdatePasswordDto dto);
    Member getDetails(Long id);
}
