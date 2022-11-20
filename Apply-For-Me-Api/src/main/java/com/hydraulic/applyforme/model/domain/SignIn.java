package com.hydraulic.applyforme.model.domain;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {


    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;

    @NotBlank(message = "{member.password.notNull}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
