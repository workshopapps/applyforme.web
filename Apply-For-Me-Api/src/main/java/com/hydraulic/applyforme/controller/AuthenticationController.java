package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.authentication.*;
import com.hydraulic.applyforme.model.exception.InvalidRefreshJwtException;
import com.hydraulic.applyforme.model.response.ForgotPasswordResponse;
import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import com.hydraulic.applyforme.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ApplyForMeUtil applyForMeUtil;

    @Autowired
    private JwtUtil jwtUtil;


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
    public String signOut() {
        return "Sign out successfully";
    }

    @PostMapping("/sign-up-verification/{email}")
    public String validateMemberSignUp(@RequestParam("otp") String otp, @PathVariable("email") String email) {
        return authenticationService.validateMemberSignUp(otp,email);
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


    // This end point should be used by FE Devs
    @PostMapping("/send-otp-for-reset-password")
    public boolean sendOtpForPasswordReset(@RequestParam String email) {
        authenticationService.sendOtpForPasswordReset(email);
        return true;
    }

    //  This EndPoint should also be used by  FE DEv too
    @PostMapping("/reset-password")
    public boolean resetPassword(@Validated @RequestBody ResetPasswordDto passwordDto) {
        authenticationService.resetPassword(passwordDto);
        return true;
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

    @PostMapping("/refresh-token")
    public SignInResponse refresh(@Validated @RequestBody RefreshTokenDto dto) throws Exception {
        try {
            String username = jwtUtil.getUsernameFromToken(dto.getRefreshToken());
            return applyForMeUtil.generateSignInToken(username);
        }
        catch (Exception e) {
            throw new InvalidRefreshJwtException();
        }

    }

}
