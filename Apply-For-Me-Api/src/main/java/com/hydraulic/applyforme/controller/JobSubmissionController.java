package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class JobSubmissionController {

    private final JobSubmissionService jobSubmissionService;

    @GetMapping("count/{applier_id}")
    public ResponseEntity<Integer> countApplierSubmissions(@PathVariable  Long applierId){

        return new ResponseEntity<>(jobSubmissionService.countAllSubmissions(applierId), HttpStatus.OK);
    }


}
