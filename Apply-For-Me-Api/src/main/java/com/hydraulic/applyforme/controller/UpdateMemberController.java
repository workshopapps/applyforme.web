package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.UpdateMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UpdateMemberController {

    @Autowired
    private UpdateMemberService memberService;

    @PutMapping("/update/{id}")
    public ResponseEntity<Member> updateDetails(@PathVariable(value = "id") Long id, @RequestBody Member member){
        return memberService.getMember(id, member);
    }

}

