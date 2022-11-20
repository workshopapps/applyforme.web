package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.http.ResponseEntity;

public interface UpdateMemberService {

   ResponseEntity<Member> getMember(long id, Member member);

}
