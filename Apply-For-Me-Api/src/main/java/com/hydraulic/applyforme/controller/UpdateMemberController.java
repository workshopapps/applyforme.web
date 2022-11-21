package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.service.UpdateMemberService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class UpdateMemberController {

    private UpdateMemberService service;

    public UpdateMemberController(UpdateMemberService memberService) {
        this.service = memberService;
    }

    @PutMapping("/update/{id}")
    public Member update(@Validated @RequestBody UpdateMemberDto body, @PathVariable(name = "id") Long id){
        return service.update(id, body);
    }
}

