package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.RecruiterCustomDto;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;

import com.hydraulic.applyforme.model.domain.Member;

import com.hydraulic.applyforme.model.response.ApplicantJobs;
import com.hydraulic.applyforme.model.response.ApplicantStats;
import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.service.impl.ApplicantServiceImpl;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "applicant",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ApplicantController {

    private final ApplicantService service;

    private  final ApplicantServiceImpl applicantService;

    @Autowired
    public ApplicantController(ApplicantService service, ApplicantServiceImpl applicantService) {
        this.service = service;
        this.applicantService = applicantService;
    }

    @GetMapping("/entries")
    public ApplyForMeResponse getAllSubmission(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getApplicationList(pageNo, pageSize, sortBy, sortDir);
    }


    @PutMapping("/update/{id}")
    public Professional update(@Validated @RequestBody ApplicantDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
   }
   
    @GetMapping("/details")
    public Member getMyDetails(Long id){
        var authenticatedUser = CurrentUserUtil.getCurrentUser();
        assert authenticatedUser != null;
        return service.getDetails(authenticatedUser.getId());

    }

    @GetMapping("/statistics")
    public ApplicantStats getApplicantsStats() {

        return applicantService.getApplicantStats();
    }

    @GetMapping("/jobs-applied")
    public ApplyForMeResponse getDetail(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getApplicantEntries(pageNo, pageSize, sortBy, sortDir);
    }
}
