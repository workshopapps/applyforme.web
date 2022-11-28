package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.dto.member.RecruiterCreateDto;

import java.util.List;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);
    List<Member> viewAllRecruiters();
    Member createRecruiter(MemberDto memberDto);
}
