package com.hydraulic.applyforme.repository;


import com.hydraulic.applyforme.model.domain.Member;


public interface UpdateMemberRepository {

    Member getOne(Long id);
    Member updateOne(Member member);
}
