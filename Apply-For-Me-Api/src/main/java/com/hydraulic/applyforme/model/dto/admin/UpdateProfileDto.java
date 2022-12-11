package com.hydraulic.applyforme.model.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.PhoneNumber;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileDto {

    @NotNull(message = "{member.firstName.notNull}")
    @JsonProperty("first_name")
    private String firstName;

    @NotNull(message = "{member.lastName.notNull}")
    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_of_birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{member.dateOfBirth.past}")
    private Date dateOfBirth;

    @JsonProperty("email_address")
    private String emailAddress;

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
