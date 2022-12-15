package com.hydraulic.applyforme.model.dto.member;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateRecruiterDto {

    @NotNull(message = "{member.firstName.notNull}")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "{member.email.notNull}")
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    @JsonProperty("email_address")
    private String emailAddress;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @NotBlank(message = "{member.password.notBlank}")
    @Size(min = 8, message = "{member.password.size}")
    @JsonProperty("password")
    private String password;

    @JsonProperty("nationality")
    private Long nationality;

    @JsonProperty("country_of_residence")
    private Long countryOfResidence;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("current_job_title")
    private String currentJobTitle;

    @JsonProperty("username")
    private String username;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumber
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("city")
    @Size(max = 300, message = "{member.city.size}")
    private String city;

    @JsonProperty("state")
    @Size(max = 300, message = "{member.state.size}")
    private String state;

}