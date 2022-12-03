package com.hydraulic.applyforme.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
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

	@GetMapping("/profiles")
	public List<ProfessionalProfile> getAllJobProfiles(@RequestParam(required = false, defaultValue = "1", name = "page") int pageOffset) {
		UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
		return service.findAllJobProfile(currentUser.getId(), pageOffset);
	}
}
