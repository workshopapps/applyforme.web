package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {
    Member findOne(Long id);
    Member save(SignupDto body);
    boolean update(Long id, UpdateMemberDto body);
}
