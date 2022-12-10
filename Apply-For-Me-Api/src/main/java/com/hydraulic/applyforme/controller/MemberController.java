package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.util.CurrentUserUtil;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class MemberController {

    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }
    
    @GetMapping("/details")
    public Member details() {
    	UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
    	return service.findOne(currentUser.getId());
    }

    @PutMapping("/update")
    public boolean update(@Validated @RequestBody UpdateMemberDto body) {
    	UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
        return service.update(currentUser.getId(), body);
    }
}
