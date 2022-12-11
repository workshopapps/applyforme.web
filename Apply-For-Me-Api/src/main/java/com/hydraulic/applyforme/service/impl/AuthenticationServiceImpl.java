package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.domain.TokenEntity;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.exception.InvalidResetTokenException;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.repository.jpa.TokenJpaRepository;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private MemberSecretJpaRepository secretJpaRepository;
    private MemberJpaRepository memberJpaRepository;
    private final TokenJpaRepository tokenJpaRepository;
    private final EmailService emailService;
    private MemberRepository memberRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(MemberSecretJpaRepository secretJpaRepository, MemberJpaRepository memberJpaRepository, TokenJpaRepository tokenJpaRepository, EmailService emailService, MemberRepository memberRepository) {
        this.secretJpaRepository = secretJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.tokenJpaRepository = tokenJpaRepository;
        this.emailService = emailService;
        this.memberRepository = memberRepository;
    }

    public String generateOtp(){
        String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
        return otp;
    }

    @Override
    @Transactional
    public String signUp(MemberDto memberDto){
        Member existingMember = memberJpaRepository.findByEmailAddress(memberDto.getEmailAddress());
        if (existingMember != null){
            throw new MemberDuplicateEntityException();
        }

        // create new member object
        Member newMember = new Member();
        newMember.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        newMember.setFirstName(memberDto.getFirstName());
        newMember.setLastName(memberDto.getLastName());
        newMember.setEmailAddress(memberDto.getEmailAddress());
        newMember.setPhoneNumber(memberDto.getPhoneNumber());


        Member saveMember = memberJpaRepository.save(newMember);
        // call generateOtp method to create a new Otp for current User
        String generatedOtp = generateOtp();
        // save Otp and new member created in the otp_table
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setOtp(generatedOtp);
        tokenEntity.setMember(saveMember);


        TokenEntity entity = tokenJpaRepository.save(tokenEntity);
        System.out.println(entity);
        emailService.signupVerification(memberDto.getEmailAddress(),generatedOtp);


        return String.format("%s,your account is created, OTP sent to your email, provide it to activate your account",entity.getMember().getFirstName());
    }

    @Transactional
    public String validateMemberSignUp(String otp,String email){
        Member member = memberJpaRepository.findByEmailAddress(email);

        TokenEntity passwordResetToken = tokenJpaRepository.findTokenEntityByOtp(otp);

        if(passwordResetToken !=null){
            Member existingMember = memberJpaRepository.findMemberByEmailAddressIgnoreCase(passwordResetToken.getMember().getEmailAddress());

            if(existingMember!=null)
            {
                existingMember.setActive(true);
                memberJpaRepository.save(existingMember);
            }
            else {
                throw  new MemberNotFoundException("Member not existing");
            }

            return String.format("%s, your account is activated, cheers",existingMember.getFirstName());
        }
        return String.format("Provided OTP may not be correct, try again later");
    }

    @Transactional
    public void resetPassword(ResetPasswordDto dto) {
        MemberSecretCode secretCodeExists = secretJpaRepository.findByForgotPasswordCode(dto.getToken());

        if (secretCodeExists == null) {
            throw new InvalidResetTokenException(dto.getToken(), dto.getEmailAddress());
        }

        Member member = memberJpaRepository.findByEmailAddress(dto.getEmailAddress());
        member.setPassword(dto.getPassword());
        setPassword(member);
        memberRepository.updateOne(member);
    }

    public void setPassword(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
    }

    @Override
    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception ex) {
            throw ex;
        }
    }
}
