package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.ForgotPasswordDto;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {

    void resetPassword(ResetPasswordDto resetPasswordDto);

    void authenticate(String username, String password) throws Exception;

    void forgotPassword(ForgotPasswordDto forgotPasswordDto);

    void matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto);

    String getByResetPasswordToken(String token);
}
