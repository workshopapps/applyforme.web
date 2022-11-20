package com.hydraulic.applyforme.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.signup.SignUpDto;

public interface MemberService {
    Member save(SignUpDto body);

    //FOR MEMBER SIGN-IN
    UserDetails loadMemberByUsername(String username);
}
