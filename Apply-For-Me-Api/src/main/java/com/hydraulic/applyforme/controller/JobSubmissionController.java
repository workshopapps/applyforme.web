package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.pojo.SubmissionResponse;
import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public ResponseEntity<SubmissionResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){

        return ResponseEntity.ok(jobSubmissionService.getAllJobSubmission(pageNo, pageSize, sortBy, sortDir));
    }


}
