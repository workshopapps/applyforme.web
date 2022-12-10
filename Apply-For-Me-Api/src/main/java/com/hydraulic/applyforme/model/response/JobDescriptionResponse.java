package com.hydraulic.applyforme.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
