package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.impl.SuperAdminServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminController {

    SuperAdminServiceImpl service;

    public SuperAdminController(SuperAdminServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Member findOne(@PathVariable(value="id") Long id) {
        return service.getDetailsById(id);
    }
}
