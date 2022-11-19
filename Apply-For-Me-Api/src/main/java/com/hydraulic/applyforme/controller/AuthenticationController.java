package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.SignUpDto;
import com.hydraulic.applyforme.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(
        value = "auth",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE}
)
public class AuthenticationController {

    private final MemberService service;

    public AuthenticationController(MemberService service) {
        this.service = service;
    }

    @PostMapping("/sign-up")
    public Member saveMember(@Validated @RequestBody SignUpDto user) {
        return service.createMember(user);
    }

}
