package com.hydraulic.applyforme.model.dto.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Role;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("nationality")
    private Country nationality;

    @JsonProperty("country_of_residence")
    private Country countryOfResidence;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("current_job_title")
    private String currentJobTitle;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("username")
    private String username;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("password")
    private String password;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("active")
    private Boolean active = false;

    @JsonProperty("created_on")
    private Date createdOn;

    @JsonProperty("updated_on")
    private Date updatedOn;

//    @JsonProperty("roles")
//    private Set<Role> roles;
}
