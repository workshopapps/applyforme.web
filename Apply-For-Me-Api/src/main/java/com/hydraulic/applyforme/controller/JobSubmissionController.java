package com.hydraulic.applyforme.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.service.ApplyForMeService;
import com.hydraulic.applyforme.service.JobSubmissionService;

@RestController
@RequestMapping(
        value = "apply",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        consumes = { MediaType.APPLICATION_JSON_VALUE }
)
public class JobSubmissionController {

    private JobSubmissionService service;

    public JobSubmissionController(JobSubmissionService service) {
        this.service = service;
    }

   
}
