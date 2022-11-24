package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.mail.MailMessage;

public interface SuperAdminRepository {
    Member  getOneMember(Long id);
    Boolean removeMemberById(Long id);
    Member viewAdminDetails(Long id);
}
