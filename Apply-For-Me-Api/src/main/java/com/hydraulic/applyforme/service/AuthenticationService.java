package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {


    String signUp(MemberDto memberDto);
    public String validateMemberSignUp(String otp, String email);

    void authenticate(String username, String password) throws Exception;
}
