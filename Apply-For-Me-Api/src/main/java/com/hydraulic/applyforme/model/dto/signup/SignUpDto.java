package com.hydraulic.applyforme.model.dto.signup;

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

    @NotNull(message = "{member.firstName.notNull}")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    private String lastName;

    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumberConstraint
    private String phoneNumber;

    @NotBlank(message = "{member.password.notNull}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
