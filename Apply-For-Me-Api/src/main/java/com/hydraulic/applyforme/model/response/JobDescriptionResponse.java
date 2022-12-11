package com.hydraulic.applyforme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.enums.JobLocationType;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDescriptionResponse {

	private Long id;
	private Applier applier;
	private String jobTitle;
	private String jobLink;
	private String jobCompany;
	private String jobLocation;
	private String jobLocationType;
	private String otherComment;
	private String jobSummary;
	private Date createdOn;
	private Date updatedOn;

}
