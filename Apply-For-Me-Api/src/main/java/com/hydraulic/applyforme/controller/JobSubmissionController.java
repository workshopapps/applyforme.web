package com.hydraulic.applyforme.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.service.JobSubmissionService;

@RestController
@RequestMapping(value = "profile", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class JobSubmissionController {

	private JobSubmissionService service;

	public JobSubmissionController(JobSubmissionService service) {
		this.service = service;
	}

	@GetMapping(value = "/{id}/submissions")
	public ResponseEntity<List<Submission>> getAllProfessionalSubmission(@PathVariable("id") Long id,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageOffset) {

		List<Submission> allSubmissions = service.getAllSubmissionsByPagination(id, pageOffset);

		return new ResponseEntity<List<Submission>>(allSubmissions, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}/submissions")
	public List<Submission> getAllProfessionalSubmissionBySortingJobTitle(@PathVariable("id") Long id,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer pageOffset,
			@RequestParam(name = "field", required = false) String field) {

		return service.getallSubmissionsSortedByField(id, pageOffset, field);
	}

}
