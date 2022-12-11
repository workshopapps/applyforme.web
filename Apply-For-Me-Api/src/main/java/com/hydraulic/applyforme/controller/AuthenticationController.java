package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.*;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.response.ForgotPasswordResponse;
import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.service.impl.UserDetailsServiceImpl;
import com.hydraulic.applyforme.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final MemberJpaRepository memberJpaRepository;

    public final EmailService emailService;

    public final AuthenticationService authenticationService;

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    public AuthenticationController(MemberService service, MemberJpaRepository memberJpaRepository, EmailService emailService, AuthenticationService authenticationService, UserDetailsServiceImpl userDetailsService) {
        this.service = service;
        this.memberJpaRepository = memberJpaRepository;
        this.emailService = emailService;
        this.authenticationService = authenticationService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody MemberDto memberDto) {
        return authenticationService.signUp(memberDto);
    }

    @PostMapping("/sign-up-verification/{email}")
    public String validateMemberSignUp(@RequestParam("otp") String otp,@PathVariable("email") String email) {
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

    @PostMapping("/generate-reset-token")
    public String generateAndSendPasswordResetToken(@RequestParam String emailAddress){
        return authenticationService.generateAndSendOtp(emailAddress);
    }
    @PostMapping("/reset-password")
    public String resetPassword(@Validated @RequestBody ResetPasswordDto passwordDto) {
        return authenticationService.passwordReset(passwordDto);
//        return "You have successfully changed your password.";
    }

    @PostMapping("/sign-in")
    public SignInResponse signIn(@Validated @RequestBody SignInDto body) throws Exception {
        try {
            authenticationService.authenticate(body.getEmailAddress(), body.getPassword());
        }
        catch(Exception ex) {
             throw ex;
        }
        return generateSignInToken(body.getEmailAddress());
    }

    protected SignInResponse generateSignInToken(String emailAddress) {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(emailAddress);

        final String token = jwtUtil.generateToken(userDetails);
        return new SignInResponse(token);
    }

}
