package com.hydraulic.applyforme.model.dto.professional;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import com.hydraulic.applyforme.model.domain.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Data
public class ApplicantDto {
    @NotNull(message = "{member.firstName.notNull}")
    private String firstName;
    @NotNull(message = "{member.lastName.notNull}")
    private String lastName;
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;
    private String nationality;
    private String countryOfResidence;
    private String username;
    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumberConstraint
    private String phoneNumber;
    private String city;
    private String state;

    @NotBlank(message = "{member.password.notNull}")
    @Size(min = 8, message = "{member.password.size}")
    private String password;

    private String avatar;
    private Boolean active = true;
    private Set<Role> roles = new HashSet<>();
    private boolean availableForInterview = false;
    private String linkedinLink;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
    private String hobbies;
    private String otherLink1;
    private String otherLink2;
    private String otherLink3;

}
