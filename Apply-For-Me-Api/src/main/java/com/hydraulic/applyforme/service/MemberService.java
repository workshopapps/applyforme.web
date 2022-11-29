package com.hydraulic.applyforme.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    Member save(SignUpDto body);

    UserDetails loadMemberByUsername(String username);

    Member findOne(Long id);
    Member save(SignupDto body);
    Member update(Long id, UpdateMemberDto body);
}
