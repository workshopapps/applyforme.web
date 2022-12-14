package com.hydraulic.applyforme.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;

}
