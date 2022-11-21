package com.hydraulic.applyforme.model.dto.member;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import com.hydraulic.applyforme.model.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberDto {

    @NotNull(message = "{member.first_name.notNull}")
    private String firstName;

    @NotNull(message = "{member.last_name.notNull}")
    private String lastName;

    private Country nationality;
    private Country countryOfResidence;

    private Date dateOfBirth;
    private String currentJobTitle;

    @NotNull(message = "{member.email_address.notNull}")
    private String emailAddress;

    private String username;

    @NotNull(message = "{member.phone_number.notNull}")
    @PhoneNumberConstraint
    private String phoneNumber;

    private String city;
    private String state;
    private String password;
    private String avatar;
    private Boolean active;
}
