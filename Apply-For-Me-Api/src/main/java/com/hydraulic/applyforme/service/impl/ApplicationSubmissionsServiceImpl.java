package com.hydraulic.applyforme.service.impl;


import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.ApplicationSubmissionsRepository;
import com.hydraulic.applyforme.service.ApplicationSubmissionsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ApplicationSubmissionsServiceImpl implements ApplicationSubmissionsService {

    private final ModelMapper modelMapper;
    //    private Submission submission;
    //    private final ResponseMapper responseMapper;
    private final ApplicationSubmissionsRepository applicationSubmissionsRepository;

    @Override
    public Collection<Submission> getAllApplicationSubmissions() {
        Collection<Submission> submissions = applicationSubmissionsRepository.findAll();
        return submissions;

    }

//    private List<ApplicationSubmissionsResponse> getAllSubmissions(Page<Submission> submissionList){
//
//        List<ApplicationSubmissionsResponse>  applicationSubmissionsResponseList = new ArrayList<>();
//
//        ApplicationSubmissionsResponse applicationSubmissionsResponse =
//                ApplicationSubmissionsResponse.builder()
//                        .applier(submission.getApplier().toString())
//                        .jobCompany(submission.getJobCompany().toString())
//                        .jobLink(submission.getJobLink().toString())
//                        .jobLocation(submission.getJobLocation().toString())
//                        .jobLocationType(submission.getJobLocationType().toString())
//                        .jobTitle(submission.getJobTitle().toString())
//                        .otherComment(submission.getOtherComment().toString())
//                        .summary(submission.getSummary().toString())
//                        .createdOn(submission.getCreatedOn().toString())
//                        .updatedOn(submission.getUpdatedOn().toString())
//                        .build();
//
//        submissionList.forEach(submission -> {
//            applicationSubmissionsResponseList.add(applicationSubmissionsResponse);
//        });
//        return applicationSubmissionsResponseList;
//    }

//    private List<ApplicationSubmissionsResponse> getAllApplicationSubmissionResponse(Page<Submission> submissionList) {
//
//        List<ApplicationSubmissionsResponse> applicationSubmissionsResponseList = new ArrayList<>();
//
//        submissionList.forEach(submission -> {
//            ApplicationSubmissionsResponse response = responseMapper.appSubmissionsResponseToSubmissionMapper(submission);
//            applicationSubmissionsResponseList.add(response);
//        });
//
//        return applicationSubmissionsResponseList;
//    }


}
