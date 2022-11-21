package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.pojo.SubmissionResponse;
import com.hydraulic.applyforme.service.JobSubmissionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hydraulic.applyforme.constants.AppConstants.*;

@RestController
@RequestMapping("/submission")
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

    @GetMapping("/job_submission")
    public  SubmissionResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return service.getAllJobSubmission(pageNo, pageSize, sortBy, sortDir);
    }


}
