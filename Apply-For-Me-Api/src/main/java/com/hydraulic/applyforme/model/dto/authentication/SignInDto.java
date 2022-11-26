package com.hydraulic.applyforme.model.dto.authentication;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInDto implements Serializable {

    @JsonProperty("email_address")
    @NotNull(message = "{member.email.notNull}")
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;

    @JsonProperty("password")
    @NotNull(message = "{member.phoneNumber.notNull}")
    @NotBlank(message = "{member.password.notBlank}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
