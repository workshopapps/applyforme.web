package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.service.superadmin.SuperAdminMemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.service.SuperAdminService;

@RestController
@RequestMapping(
        value = "super-admin/member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminMemberController {

    private final SuperAdminMemberService service;

    public SuperAdminMemberController(SuperAdminMemberService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Member getMember(@PathVariable(value="id") Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        return service.deleteMember(id);
    }
}
