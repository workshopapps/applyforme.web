package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;

import java.util.List;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);
    List<Applier> viewAllRecruiters();

    Member createRecruiter(MemberDto memberDto);
    Member updatePassword(Long id, UpdatePasswordDto dto);
    Member getDetails(Long id);
}
