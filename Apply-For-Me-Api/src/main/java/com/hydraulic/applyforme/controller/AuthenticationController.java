package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.authentication.*;
import com.hydraulic.applyforme.model.response.ForgotPasswordResponse;
import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.service.impl.UserDetailsServiceImpl;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import com.hydraulic.applyforme.util.JwtUtil;
import com.hydraulic.applyforme.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private ApplyForMeUtil applyForMeUtil;


    public AuthenticationController(MemberService service, EmailService emailService, AuthenticationService authenticationService) {
        this.service = service;
        this.emailService = emailService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public SignInResponse signUp(@Validated @RequestBody SignupDto body) {
        service.save(body);
//        emailService.sendWelcomeMessage(body.getEmailAddress());
        return applyForMeUtil.generateSignInToken(body.getEmailAddress());
    }

    @PostMapping("/sign-out")
    public String signout() {
        return "Sign out successfully";
    }

    @PostMapping("/sign-up-verification")
    public String signupVerificationCode(@Validated @RequestBody SignupVerificationDto verificationDto) {
//        emailService.signupVerification(verificationDto.getEmailAddress());
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

    @PostMapping("/sign-in")
    public SignInResponse signIn(@Validated @RequestBody SignInDto body) throws Exception {
        try {
            authenticationService.authenticate(body.getEmailAddress(), body.getPassword());
        }
        catch(Exception ex) {
             throw ex;
        }
        return applyForMeUtil.generateSignInToken(body.getEmailAddress());
    }

}
