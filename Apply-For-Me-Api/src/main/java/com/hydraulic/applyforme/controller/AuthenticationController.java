package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.ForgotPasswordDto;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.authentication.SignupVerificationDto;
import com.hydraulic.applyforme.model.view.ForgotPasswordResponse;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(
        value = "auth",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class AuthenticationController {

    private final MemberService service;

    public final EmailService emailService;

    public final AuthenticationService authenticationService;

    public AuthenticationController(MemberService service, EmailService emailService, AuthenticationService authenticationService) {
        this.service = service;
        this.emailService = emailService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public Member signUp(@Validated @RequestBody SignupDto body) {
        Member member = service.save(body);
        emailService.sendWelcomeMessage(body.getEmailAddress());
        return member;
    }

    @PostMapping("/sign-up-verification")
    public String signupVerificationCode(@Validated @RequestBody SignupVerificationDto verificationDto) {
        emailService.signupVerification(verificationDto.getEmailAddress());
        return "Sign up verification code sent";
    }

    @PostMapping("/forgot-password")
    public ForgotPasswordResponse forgotPassword(HttpServletRequest request, @Validated @RequestBody ForgotPasswordDto passwordDto) {
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();
        emailService.sendResetPasswordMail(passwordDto.getEmailAddress(), baseUrl);
        return new ForgotPasswordResponse();
    }

    @PostMapping("/reset-password")
    public String resetPassword(@Validated @RequestBody ResetPasswordDto passwordDto) {
        authenticationService.resetPassword(passwordDto);
        return "You have successfully changed your password.";
    }

}
