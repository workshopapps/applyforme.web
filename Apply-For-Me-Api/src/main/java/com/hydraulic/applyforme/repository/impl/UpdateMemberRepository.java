package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface UpdateMemberRepository extends JpaRepository<Member, Long> {
}
