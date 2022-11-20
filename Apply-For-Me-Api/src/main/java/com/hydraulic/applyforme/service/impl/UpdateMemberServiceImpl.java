package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.impl.UpdateMemberRepository;
import com.hydraulic.applyforme.service.UpdateMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {

    @Autowired
    private UpdateMemberRepository memberRepository;

    @Override
    public ResponseEntity<Member> getMember(long id, Member member) {

        Member getMember = memberRepository.findById(id).get();

        getMember.setFirstName(member.getFirstName());
        getMember.setLastName(member.getLastName());
        getMember.setNationality(member.getNationality());
        getMember.setCountryOfResidence(member.getCountryOfResidence());
        getMember.setDateOfBirth(member.getDateOfBirth());
        getMember.setCurrentJobTitle(member.getCurrentJobTitle());
        getMember.setEmailAddress(member.getEmailAddress());
        getMember.setPassword(member.getPassword());
        getMember.setAvatar(member.getAvatar());
        getMember.setActive(member.getActive());


        Member updateMember = memberRepository.save(getMember);
        return ResponseEntity.ok().body(updateMember);
    }

}
