package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.service.MemberService;
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

    @PutMapping("/update/{id}")
    public Member update(@PathVariable(name = "id") Long id, @Validated @RequestBody UpdateMemberDto body) {
        return service.update(id, body);
    }
}
