package com.hydraulic.applyforme.model.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("otp")
    private String otp;

    @NotNull(message = "member.email.notNull")
    @JsonProperty("email_address")
    private String emailAddress;

    @NotNull(message = "resetPassword.password.notNull")
    @Size(min = 8, message = "{member.password.size}")
    @JsonProperty("new_password")
    private String newPassword;
}
