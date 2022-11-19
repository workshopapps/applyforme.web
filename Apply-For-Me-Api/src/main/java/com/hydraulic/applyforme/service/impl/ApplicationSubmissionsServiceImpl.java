package com.hydraulic.applyforme.service.impl;


import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.service.ApplicationSubmissionsService;
import com.hydraulic.applyforme.view.ApplicationSubmissionsResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationSubmissionsServiceImpl implements ApplicationSubmissionsService {

    private Submission submission;

    private List<ApplicationSubmissionsResponse> getAllSubmissions(Page<Submission> submissionList){

        List<ApplicationSubmissionsResponse>  applicationSubmissionsResponseList = new ArrayList<>();

        ApplicationSubmissionsResponse applicationSubmissionsResponse =
                ApplicationSubmissionsResponse.builder()
                        .applier(submission.getApplier().toString())
                        .jobCompany(submission.getJobCompany().toString())
                        .jobLink(submission.getJobLink().toString())
                        .jobLocation(submission.getJobLocation().toString())
                        .jobLocationType(submission.getJobLocationType().toString())
                        .jobTitle(submission.getJobTitle().toString())
                        .otherComment(submission.getOtherComment().toString())
                        .summary(submission.getSummary().toString())
                        .createdOn(submission.getCreatedOn().toString())
                        .updatedOn(submission.getUpdatedOn().toString())
                        .build();

        submissionList.forEach(submission -> {
            applicationSubmissionsResponseList.add(applicationSubmissionsResponse);
        });
        return applicationSubmissionsResponseList;
    }

    @Override
    public List<ApplicationSubmissionsResponse> getAllApplicationSubmissions(int offset, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(offset, pageSize);

//        Page<Submission> submissionsList = applicationSubmissionsDTO.getAllApplicationSubmisions(pageable);

//        return submissionsList (submissionsList);
        return null;
    }
}
