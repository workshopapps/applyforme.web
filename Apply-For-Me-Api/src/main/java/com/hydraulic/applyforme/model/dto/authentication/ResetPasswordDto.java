package com.hydraulic.applyforme.model.dto.authentication;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDto {

    @NotNull(message = "resetPassword.token.notNull")
    private String token;

    @NotNull(message = "member.email.notNull")
    private String emailAddress;

    @NotNull(message = "resetPassword.password.notNull")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
