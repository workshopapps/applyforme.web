package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.impl.ApplicantServiceImpl;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "applicant/member",
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class ApplicantController {
    private final ApplicantServiceImpl applicantService;

    public ApplicantController(ApplicantServiceImpl applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/details")
    public Member getMyDetails(Long id){
        var authenticatedUser = CurrentUserUtil.getCurrentUser();
        assert authenticatedUser != null;
        return applicantService.getDetails(authenticatedUser.getId());
    }
}



