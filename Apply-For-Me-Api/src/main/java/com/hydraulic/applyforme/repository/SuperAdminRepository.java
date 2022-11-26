package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.mail.MailMessage;

public interface SuperAdminRepository {

    Member saveOne(Member body);

    Member getOneMember(Long id);
    Boolean removeMemberById(Long id);
    Member viewAdminDetails(Long id);
}
