package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminRepository {
    Member  getOneMember(Long id);
    Boolean removeMemberById(Long id);

/*
 * REPOSITORY JPA REPO
 * @Query("select m from Member m )
 *  Member findAll();
 *  List<Member> getAll();
 *
 * SERVICE INTERFACE:
 * List<Member> viewRecruiters();
 */
}
