package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.SignUpDto;

public interface MemberService {
    Member createMember(SignUpDto body);
}
