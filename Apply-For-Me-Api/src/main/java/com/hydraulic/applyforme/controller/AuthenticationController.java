package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.signup.SignUpDto;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(
        value = "auth",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class AuthenticationController {

    private final MemberService service;

    public final EmailService emailService;

    public AuthenticationController(MemberService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

    @PostMapping("/sign-up")
    public Member saveMember(@Validated @RequestBody SignUpDto user) {
        Member newMember = service.save(user);
        if (newMember != null) {
            emailService.sendWelcomeMessage(user.getEmailAddress());
        }
        //return service.save(user);
        return newMember;
    }

}
