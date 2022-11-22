package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface MemberRepository {
    public void updatePassword(String emailAddress, String newPassword);
    public Member findByEmailAddress(String emailAddress);
    public void save(Member member);
}
