package com.hydraulic.applyforme.model.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDto {

    @JsonProperty("refresh_token")
    @NotNull(message = "auth.refreshToken.notNull")
    private String refreshToken;
}
