package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.service.impl.SuperAdminServiceImpl;
import com.hydraulic.applyforme.service.superadmin.SuperAdminMemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.service.SuperAdminService;

import java.util.List;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "super-admin/member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminMemberController {

    private final SuperAdminMemberService service;
    private final SuperAdminServiceImpl adminService;

    public SuperAdminMemberController(SuperAdminMemberService service, SuperAdminServiceImpl adminService) {
        this.service = service;
        this.adminService = adminService;
    }

//    @PostMapping("/create-admin")
//    public Member createAdmin(@RequestBody MemberDto memberDto){
//        return service.addAdmin(memberDto);
//
//    }

    @GetMapping("/detail/{id}")
    public Member getMember(@PathVariable(value="id") Long id) {
        return service.getOne(id);
    }

    @GetMapping("/recruiter/all")
    public ApplyForMeResponse getAllMember(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return service.viewAllRecruiters(pageNo, pageSize, sortBy, sortDir);
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        return service.deleteMember(id);
    }
}
