package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;

public interface AuthenticationService {

    void resetPassword(ResetPasswordDto resetPasswordDto);

    void updatePassword();
}
