package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {

    void resetPassword(ResetPasswordDto resetPasswordDto);
}
