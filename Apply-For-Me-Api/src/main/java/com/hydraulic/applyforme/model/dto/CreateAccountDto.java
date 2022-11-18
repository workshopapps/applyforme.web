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
public class CreateAccountDto {

    @NotEmpty(message = "{firstName.field.notEmpty}")
    private String firstName;

    @NotEmpty(message = "{lastName.field.notEmpty}")
    private String lastName;

    @NotBlank(message = "{email.field.notBlank}")
    @Email(message = "{email.field.valid}")
    private String emailAddress;

    @NotBlank(message = "{phoneNumber.field.notBlank}")
    @PhoneNumberConstraint
    private String phoneNumber;

    @NotBlank(message = "{password.field.notBlank}")
    @Size(min = 8, message = "{password.field.size}")
    private String password;
}
