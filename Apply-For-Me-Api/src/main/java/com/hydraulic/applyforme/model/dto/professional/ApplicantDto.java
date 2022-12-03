package com.hydraulic.applyforme.model.dto.professional;

import com.hydraulic.applyforme.annotation.PhoneNumberConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ApplicantDto {

        @NotNull(message = "{member.firstName.notNull}")
        private String firstName;
        @NotNull(message = "{member.lastName.notNull}")
        private String lastName;
        @NotBlank(message = "{member.email.notBlank}")
        @Email(message = "{member.email.valid}")
        private String emailAddress;

        @Size(min=5, max = 20, message = "{country.title.size}")
        @NotNull(message = "{country.title.notNull}")
        private String nationality;

        @Size(min=2, max=6, message = "{country.title.size}")
        private String countryAbbreviation;

        @Size(min=5, max=20, message = "{country.title.size}")
        @NotNull(message = "{country.title.notNull}")
        private String countryOfResidence;

        @Size(min=2, max=6, message = "{country.title.size}")
        private String countryOfResidenceAbbreviation;

        @Size(min=5, max = 20, message = "{country.title.size}")
        private String currentJobTitle;

        @Size(min=3, max = 10, message = "Username should not be less than 3 or more than 10 character ")
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
        private String dateOfBirth;
        private boolean availableForInterview = false;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String linkedinLink;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String facebookLink;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String twitterLink;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String instagramLink;
        @Size(min = 3, max = 300, message = "{professional.hobby.size}")
        private String hobbies;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String otherLink1;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String otherLink2;
        @Size(min = 15, max = 300, message = "{professional.socialLink.size}")
        private String otherLink3;
}
