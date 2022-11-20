package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.pojo.SubmissionResponse;
import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

import static com.hydraulic.applyforme.constants.AppConstants.*;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class JobSubmissionController {

    private final JobSubmissionService jobSubmissionService;

    @GetMapping("count/{applierId}")
    public Long countApplierSubmissions(@PathVariable  Long applierId){

        return jobSubmissionService.countAllSubmissions(applierId);
    }

    @GetMapping("/job_submission")
    public SubmissionResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){

        return jobSubmissionService.getAllJobSubmission(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/job_submission/search")
    public List<Submission> getAllPosts(@RequestParam String q) {

        return jobSubmissionService.getSubmissionsBySearch(q).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found"));

    }

    @GetMapping("/entries/job_submission")
    public List<Submission> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return jobSubmissionService.findAll(pageNumber);
    }


}
