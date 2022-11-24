package com.hydraulic.applyforme.model.dto.authentication;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    @NotNull(message = "{member.firstName.notNull}")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    private String lastName;

    @NotNull(message = "{member.email.notNull}")
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumberConstraint
    private String phoneNumber;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @NotBlank(message = "{member.password.notBlank}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;
}
