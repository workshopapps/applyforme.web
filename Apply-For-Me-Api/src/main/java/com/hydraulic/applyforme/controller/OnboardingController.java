package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.NewPasswordDto;
import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
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
	private final EmailService emailService;

	private final ApplyForMeUtil applyForMeUtil;
	
	public OnboardingController(OnboardingService service, EmailService emailService, ApplyForMeUtil applyForMeUtil) {
		super();
		this.service = service;
		this.emailService = emailService;
		this.applyForMeUtil = applyForMeUtil;
	}

	@PostMapping("/onboard")
	public OnboardingResponse onboard(@Validated @RequestBody TryItNowDTO body) {
		OnboardingResponse response = service.onboard(body);
//		emailService.onboard(response, response.getOnBoardToken());
		return response;
	}
	
	@PutMapping("/{token}/complete-onboard")
	public SignInResponse changePassword(@PathVariable("token") String onboardToken, @Validated @RequestBody NewPasswordDto body) {
		Member member = service.changePassword(onboardToken, body);
		return applyForMeUtil.generateSignInToken(member.getEmailAddress());
	}
}
