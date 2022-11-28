package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.mail.MailMessage;

public interface SuperAdminRepository {

    Member saveOne(Member body);

    Member getOneMember(Long id);
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

    Member viewAdminDetails(Long id);

}
