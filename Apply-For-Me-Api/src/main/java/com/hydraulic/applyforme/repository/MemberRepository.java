package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> getAll();

    List<Member> getAll(Integer pageOffSet);

    Member getOne(Long id);

    Member saveOne(Member member);

    Member updateOne(Member member);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}
