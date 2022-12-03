package com.hydraulic.applyforme.model.dto.authentication;


import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class SignInDto implements Serializable {

    @NotNull(message = "{member.email.notNull}")
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @NotBlank(message = "{member.password.notBlank}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
