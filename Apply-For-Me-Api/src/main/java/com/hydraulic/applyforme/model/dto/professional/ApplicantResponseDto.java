package com.hydraulic.applyforme.model.dto.professional;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.domain.Submission;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class ApplicantResponseDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String nationality;
    private String countryOfResidence;
    private String username;
    // add validation
    private String phoneNumber;
    private String city;
    private String state;
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
    private Set<Submission> submissions = new HashSet<>();

}
