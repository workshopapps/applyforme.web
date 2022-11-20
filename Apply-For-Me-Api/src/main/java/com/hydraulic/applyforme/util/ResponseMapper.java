//package com.hydraulic.applyforme.util;
//
//import com.hydraulic.applyforme.model.domain.Submission;
//import com.hydraulic.applyforme.view.ApplicationSubmissionsResponse;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ResponseMapper {
//
//    public ApplicationSubmissionsResponse appSubmissionsResponseToSubmissionMapper(Submission submission) {
//      ApplicationSubmissionsResponse applicationSubmissionsResponse = new ApplicationSubmissionsResponse();
//
////        ApplicationSubmissionsResponseApplicationSubmissionsResponse =
////                ApplicationSubmissionsResponse.builder()
////                        .applier(submission.getApplier().toString())
////                        .jobCompany(submission.getJobCompany().toString())
////                        .jobLink(submission.getJobLink().toString())
////                        .jobLocation(submission.getJobLocation().toString())
////                        .jobLocationType(submission.getJobLocationType().toString())
////                        .jobTitle(submission.getJobTitle().toString())
////                        .otherComment(submission.getOtherComment().toString())
////                        .summary(submission.getSummary().toString())
////                        .createdOn(submission.getCreatedOn().toString())
////                        .updatedOn(submission.getUpdatedOn().toString())
////                        .build();
//
//        if(submission.getApplier() != null){
//            applicationSubmissionsResponse.setApplier(submission.getApplier().toString());
//        }
//
//        if(submission.getCreatedOn() != null){
//            applicationSubmissionsResponse.setCreatedOn(submission.getCreatedOn().toString());
//        }
//
//        if (submission.getJobLink() != null) {
//            applicationSubmissionsResponse.setJobLink(submission.getJobLink());
//        }
//
//        if(submission.getSummary() != null){
//            applicationSubmissionsResponse.setSummary(submission.getSummary());
//        }
//        if (submission.getJobCompany() != null) {
//            applicationSubmissionsResponse.setJobCompany(submission.getJobCompany());
//        }
//        if(submission.getJobLocationType() != null){
//            applicationSubmissionsResponse.setJobLocationType(submission.getJobLocationType().toString());
//        }
//        if (submission.getJobTitle() != null) {
//            applicationSubmissionsResponse.setJobTitle(submission.getJobTitle());
//        }
//        if (submission.getJobLocation() != null) {
//            applicationSubmissionsResponse.setJobLocation(submission.getJobLocation());
//        }
//        if (submission.getOtherComment() != null) {
//            applicationSubmissionsResponse.setOtherComment(submission.getOtherComment());
//        }
//        if (submission.getUpdatedOn() != null) {
//            applicationSubmissionsResponse.setUpdatedOn(submission.getUpdatedOn().toString());
//        }
//        return applicationSubmissionsResponse;
//    }
//}
//
