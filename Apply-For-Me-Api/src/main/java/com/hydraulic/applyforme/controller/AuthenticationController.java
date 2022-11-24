package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.authentication.*;
import com.hydraulic.applyforme.model.response.ForgotPasswordResponse;
import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.service.impl.UserDetailsServiceImpl;
import com.hydraulic.applyforme.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    public AuthenticationController(MemberService service, EmailService emailService, AuthenticationService authenticationService, UserDetailsServiceImpl userDetailsService) {
        this.service = service;
        this.emailService = emailService;
        this.authenticationService = authenticationService;
        this.userDetailsService = userDetailsService;
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

    @PostMapping("/sign-in")
    public SignInResponse signIn(@Validated @RequestBody SignInDto body) throws Exception {
        authenticate(body.getEmailAddress(), body.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(body.getEmailAddress());

        final String token = jwtUtil.generateToken(userDetails);

        return new SignInResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
