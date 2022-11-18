package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.CreateAccountDto;
import com.hydraulic.applyforme.service.SignUpService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(
        value = "auth",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE}
)
public class SignUpController {

    private final SignUpService service;

    public SignUpController(SignUpService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Member signUp(@Validated @RequestBody CreateAccountDto user) {
        return service.signUp(user);
    }

}
