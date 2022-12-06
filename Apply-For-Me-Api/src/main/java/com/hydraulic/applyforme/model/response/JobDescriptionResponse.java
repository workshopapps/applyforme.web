package com.hydraulic.applyforme.model.response;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDescriptionResponse {

    public String jobTitle;

    public String jobCompany;

    public String jobLocation;

    public Date date;

    public String monthlySalaryRange;

    public String jobSummary;


}
