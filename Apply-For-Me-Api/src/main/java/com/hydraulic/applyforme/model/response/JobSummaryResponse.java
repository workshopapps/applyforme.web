package com.hydraulic.applyforme.model.response;

import com.hydraulic.applyforme.model.enums.JobLocationType;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class JobSummaryResponse {
    private Long submissionId;
    private String jobTitle;
    private String jobLocation;
    private String jobCompany;
    private JobLocationType jobLocationType;
    private Date createdOn;
    private String salaryRange = "";
}