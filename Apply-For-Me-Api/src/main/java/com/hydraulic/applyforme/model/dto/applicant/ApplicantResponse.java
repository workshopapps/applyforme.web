package com.hydraulic.applyforme.model.dto.applicant;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @RequiredArgsConstructor
@Builder
public class ApplicantResponse {

    private Long id;
    private String jobCompany;
    private String jobTitle;
    private String jobLocation;
    private String jobType;
    private String salaryRange;
    private Date date;
}
