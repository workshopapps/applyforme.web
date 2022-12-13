package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.model.response.UserDashboardStatisticsOne;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface MemberService {
    Member findOne(Long id);
    Member save(SignupDto body);
    boolean update(Long id, UpdateMemberDto body);
    @Transactional
    Member updatePassword(Long id, UpdatePasswordDto dto) throws PasswordMismatchException;
    UserDashboardStatisticsOne getStatistics(Long id, Date from, Date to);
}
