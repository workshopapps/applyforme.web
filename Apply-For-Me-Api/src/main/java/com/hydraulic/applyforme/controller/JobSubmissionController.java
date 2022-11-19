package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class JobSubmissionController {

    private final JobSubmissionService service;

    public JobSubmissionController(JobSubmissionService service) {
        this.service = service;
    }
    @GetMapping("/applier/count/{applierId}")
    public Long countApplierSubmission(@PathVariable(name = "applierId") Long id){
        return service.countAllSubmissions(id);
    }


}
