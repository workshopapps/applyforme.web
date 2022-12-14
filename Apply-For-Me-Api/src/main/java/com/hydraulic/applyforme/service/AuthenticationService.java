package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.member.MemberDto;

public interface AuthenticationService {
    String signUp(MemberDto memberDto);
    public String validateMemberSignUp(String otp, String email);

    void resetPassword(ResetPasswordDto resetPasswordDto);

    void authenticate(String username, String password) throws Exception;
}
