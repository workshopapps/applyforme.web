package com.hydraulic.applyforme.model.dto.email;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordDto {

    @NotNull(message = "resetPassword.token.notNull")
    private String token;

    @NotNull(message = "resetPassword.password.notNull")
    private String password;

    @Builder()
    public ResetPasswordDto (String token, String password){
        this.token = token;
        this.password = password;
    }
}
