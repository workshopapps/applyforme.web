package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.UpdateMemberDto;
import com.hydraulic.applyforme.service.UpdateMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UpdateMemberController {

    @Autowired
    private UpdateMemberService memberService;

    @PostMapping("/update")
    public UpdateMemberDto updateDetails(@PathVariable(value = "id") long id){

        return memberService.updateMember(id);
    }

}
