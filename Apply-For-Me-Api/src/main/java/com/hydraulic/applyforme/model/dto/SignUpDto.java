package com.hydraulic.applyforme.model.dto;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    @NotEmpty(message = "member.firstName.notEmpty")
    private String firstName;

    @NotEmpty(message = "member.lastName.notEmpty")
    private String lastName;

    @NotBlank(message = "member.email.notBlank")
    @Email(message = "member.email.valid")
    private String emailAddress;

    @NotBlank(message = "member.phoneNumber.notBlank")
    @PhoneNumberConstraint
    private String phoneNumber;

    @NotBlank(message = "member.password.notBlank")
    @Size(min = 8, message = "member.password.size")
    private String password;
}
