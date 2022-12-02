package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.mail.MailMessage;

public interface SuperAdminRepository {
    Member updatePassword(Long id, String newPassword);

    Member viewProfileDetails (Long id);
}
