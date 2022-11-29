package com.hydraulic.applyforme.model.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberDto {

    @NotNull(message = "{member.firstName.notNull}")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("nationality")
    private Long nationality;

    @JsonProperty("country_of_residence")
    private Long countryOfResidence;

    @JsonProperty("date_of_birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Past(message = "{customer.dateOfBirth.past}")
    private Date dateOfBirth;

    @JsonProperty("current_job_title")
    private String currentJobTitle;

    @NotNull(message = "{member.emailAddress.notNull}")
    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("username")
    private String username;

    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumber
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Size(max = 300, message = "{member.city.size}")
    @JsonProperty("city")
    private String city;

    @Size(max = 300, message = "{member.state.size}")
    @JsonProperty("state")
    private String state;
}
