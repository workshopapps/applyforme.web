package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.NewPasswordDto;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import com.hydraulic.applyforme.service.OnboardingService;

@RestController
@RequestMapping(
        value = "visitor",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class OnboardingController {

	public final OnboardingService service;
	
	public OnboardingController(OnboardingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/onboard")
	public OnboardingResponse onboard(@Validated @RequestBody TryItNowDTO body) {
		return service.onboard(body);
	}
	
	@PutMapping("/{token}/complete-onboard")
	public Member changePassword(@PathVariable("token") String onboardToken, @Validated @RequestBody NewPasswordDto body) {
		return service.changePassword(onboardToken, body);
	}
}
