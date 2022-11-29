package com.hydraulic.applyforme.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.SignIn;
import com.hydraulic.applyforme.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(
        value = "auth",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)

public class SignInController {

    
    private final MemberService service;

    public SignInController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/sign-in")
    public UserDetails retrieveMember(@Validated @RequestBody SignIn signInDetails) {
        return service.loadMemberByUsername(signInDetails.getEmailAddress());
    }
}
