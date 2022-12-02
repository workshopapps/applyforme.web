package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.mail.MailMessage;

import java.util.List;

public interface SuperAdminRepository {

    Member saveOne(Member body);
    Member getOneMember(Long id);
    Boolean removeMemberById(Long id);
    Member viewAdminDetails(Long id);
    Member updatePassword(Long id, String newPassword);

}
