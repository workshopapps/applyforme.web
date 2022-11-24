package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.password.ChangePasswordDto;
import com.hydraulic.applyforme.service.ChangePasswordService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "password",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ChangePasswordController {

    private ChangePasswordService service;

    public ChangePasswordController(ChangePasswordService passwordService) {
        this.service = passwordService;
    }

    @PostMapping("/change-password/{id}")
    public Member changePassword(@Validated @RequestBody ChangePasswordDto password, @PathVariable(name = "id") Long id){
        return service.changePassword(id, password);
    }
}
