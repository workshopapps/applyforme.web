package com.hydraulic.applyforme.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.ProfessionalService;
import com.hydraulic.applyforme.util.CurrentUserUtil;

@RestController
@RequestMapping(value = "professional", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfessionalController {

	private ProfessionalService service;

	public ProfessionalController(ProfessionalService service) {
		this.service = service;
	}

	@GetMapping("/entries")
	public List<Professional> findAll(
			@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageOffset) {
		return service.findAll(pageOffset);
	}

	@GetMapping("/detail/{id}")
	public Professional findOne(@PathVariable(name = "id") Long id) {
		return service.findOne(id);
	}

	@PutMapping("/update")
	public Professional update(@Validated @RequestBody ProfessionalDto body) {
		// public Professional update(@Validated @RequestBody ProfessionalDto body, Long
		// id) {
		Long id = CurrentUserUtil.getCurrentUser().getId();
		return service.updateProfile(body, id);
	}

	@PutMapping("/update/{id}")
	public Professional update(@Validated @RequestBody ProfessionalDto body, @PathVariable(name = "id") Long id) {
		return service.updateProfile(body, id);
	}

	@GetMapping("/applicants/{pageNo}/{pageSize}")
	public Page<Professional> retrieveApplicants(@PathVariable int pageNo, @PathVariable int pageSize) {
		return service.retrieveAllProfessionals(pageNo, pageSize);
	}

	@GetMapping("/profiles")
	public List<ProfessionalProfile> getAllJobProfiles(
			@RequestParam(required = false, defaultValue = "1", name = "page") int pageOffset) {
		UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
		return service.findAllJobProfile(currentUser.getId(), pageOffset);
	}
}
