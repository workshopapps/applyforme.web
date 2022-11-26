package com.hydraulic.applyforme.model.dto.password;

import com.hydraulic.applyforme.model.domain.Member;
import lombok.Data;

@Data
public class ChangePasswordDto {

    private String password;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
}
