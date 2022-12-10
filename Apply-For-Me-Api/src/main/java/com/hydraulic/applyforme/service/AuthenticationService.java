package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {

    String passwordReset(ResetPasswordDto resetPasswordDto);
    String generateAndSendOtp(String emailAddress);

    void authenticate(String username, String password) throws Exception;
}
