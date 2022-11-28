package com.hydraulic.applyforme.model.dto.contactUs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsDto {

    @NotNull(message = "{member.firstName.notNull}")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    private String lastName;

    @NotNull(message = "{member.emailAddress.notNull}")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    private String phoneNumber;

    @NotNull(message = "{member.message.notNull}")
    private String message;

    private Boolean readPrivacyPolicy;
}
