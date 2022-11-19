package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.signup.SignUpDto;

public interface MemberService {
    Member createMember(SignUpDto body);
}
