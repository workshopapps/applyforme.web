package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @PostMapping("/create-admin")
//    public Member createAdmin(@RequestBody MemberDto memberDto){
//        return service.addAdmin(memberDto);
//
//    }

    @GetMapping("/detail/{id}")
    public Member getOneMember(@PathVariable(value="id") Long id) {
        return service.getDetailsById(id);
    }

    @GetMapping("/profile/{id}")
    public Member viewAdmin(@PathVariable(value = "id") Long id){
        return service.getAdmin(id);
    }

    @GetMapping("/recruiter/all")
    public List<Applier> getAllMember(){
        return service.viewAllRecruiters();
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable(value = "id") Long id){
        return service.deleteMemberById(id);
    }
}
