package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "admin/member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminMemberController {

    private SuperAdminService service;

    public SuperAdminMemberController(SuperAdminService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Member getOneMember(@PathVariable(value="id") Long id) {
        return service.getDetailsById(id);
    }

    @GetMapping("/profile/{id}")
    public Member viewAdmin(@PathVariable(value = "id") Long id){
        return service.getAdmin(id);
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable(value = "id") Long id){
        return service.deleteMemberById(id);
    }
}
