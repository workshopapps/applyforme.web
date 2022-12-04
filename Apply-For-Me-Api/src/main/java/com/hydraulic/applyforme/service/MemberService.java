package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;

public interface MemberService {
    Member findOne(Long id);
    Member save(SignupDto body);
}
