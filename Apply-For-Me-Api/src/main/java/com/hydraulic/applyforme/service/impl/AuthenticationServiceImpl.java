package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.exception.InvalidResetTokenException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService {

    MemberSecretJpaRepository secretJpaRepository;

    MemberJpaRepository memberJpaRepository;

    MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(MemberSecretJpaRepository secretJpaRepository, MemberJpaRepository memberJpaRepository, MemberRepository memberRepository) {
        this.secretJpaRepository = secretJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberRepository = memberRepository;
    }

    public void resetPassword(ResetPasswordDto passwordDto) {
        MemberSecretCode secretCodeExists = secretJpaRepository.findByForgotPasswordCode(passwordDto.getToken());

        if (secretCodeExists == null) {
            throw new InvalidResetTokenException(passwordDto.getToken(), passwordDto.getEmailAddress());
        }

        Member member = memberJpaRepository.findByEmailAddress(passwordDto.getEmailAddress());
        member.setPassword(passwordDto.getPassword());
        setPassword(member);
        memberRepository.updateOne(member);
    }

    @Override
    public void updatePassword() {

    }

    public void setPassword(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
    }
}
