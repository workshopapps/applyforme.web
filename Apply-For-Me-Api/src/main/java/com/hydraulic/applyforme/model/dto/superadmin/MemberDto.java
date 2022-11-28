package com.hydraulic.applyforme.model.dto.superadmin;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String firstName;
    private String lastName;
    private Country nationality;
    private String currentJobTitle;
    private String emailAddress;
    private String username;
    private String phoneNumber;
    private String city;
    private String state;
    private RoleDto role;

}
