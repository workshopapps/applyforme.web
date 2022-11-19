package com.hydraulic.applyforme.model.dto.professional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalFetchDto {

    private String firstName;

    private  String lastName;

    private String jobTitle;

    private String jobLocationType;

    private String experience;

    private String salaryRange;
}
