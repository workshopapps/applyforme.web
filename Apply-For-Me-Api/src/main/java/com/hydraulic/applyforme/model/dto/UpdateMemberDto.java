package com.hydraulic.applyforme.model.dto;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateMemberDto {

    private UpdateMemberDto member;

    public UpdateMemberDto(UpdateMemberDto member) {
        this.member = member;
    }

    private Long id;
    private String firstName;
    private String lastName;
    private Country nationality;
    private Country countryOfResidence;

    private Date dateOfBirth;
    private String currentJobTitle;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private String avatar;
    private Boolean active;
    private Date createdOn;
    private Date updatedOn;
}

