package com.hydraulic.applyforme.model.dto.contactUs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsDto {

    @NotNull(message = "{member.firstName.notNull}")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "{member.emailAddress.notNull}")
    @Email(message = "{contactUs.emailAddress.valid}")
    @JsonProperty("email_address")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumber
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull(message = "{member.message.notNull}")
    @JsonProperty("message")
    private String message;

    @JsonProperty("privacy_policy")
    private Boolean privacyPolicy;
}
