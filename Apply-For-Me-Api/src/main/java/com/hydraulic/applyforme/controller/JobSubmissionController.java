package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class JobSubmissionController {

    private final JobSubmissionService jobSubmissionService;

    @GetMapping("count/{applierId}")
    public Long countApplierSubmissions(@PathVariable  Long applierId){
        System.out.println("HI");
        return jobSubmissionService.countAllSubmissions(applierId);
    }


}
