package com.hydraulic.applyforme.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.service.JobSubmissionService;

@RestController
@RequestMapping(
        value = "submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
@CrossOrigin("*")
public class JobSubmissionController {

    private final JobSubmissionService service;

    public JobSubmissionController(JobSubmissionService service) {
        this.service = service;
    }
    
    @GetMapping("/applier/count/{applierId}")
    public Long countApplierSubmission(@PathVariable(name = "applierId") Long id){
        return service.countAllSubmissions(id);
    }
        
    @GetMapping(value = "/{id}/submissions")
	public ResponseEntity<List<Submission>> getAllSubmission(@PathVariable("id") Long id,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageOffset) {

    	System.out.println("hey there i'm working");
		List<Submission> allSubmissions = service.getAllSubmissionsByPagination(id, pageOffset);

		return new ResponseEntity<List<Submission>>(allSubmissions, HttpStatus.OK);
	}

}
