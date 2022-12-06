package com.hydraulic.applyforme.model.response;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDescriptionResponse {

    public String jobTitle;

    public String jobCompany;

    public String jobLocation;

    public String date;

    public String monthlySalaryRange;

    public String jobSummary;

    public String Responsibilities;

}
