package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;

import com.hydraulic.applyforme.model.domain.PasswordResetTokenEntity;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.PasswordResetRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.repository.jpa.PasswordResetTokenJPARepository;
import com.hydraulic.applyforme.service.AuthenticationService;
import com.hydraulic.applyforme.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private MemberSecretJpaRepository secretJpaRepository;
    private MemberJpaRepository memberJpaRepository;
    private MemberRepository memberRepository;
    private final PasswordResetRepository resetRepository;

    private PasswordResetTokenJPARepository passwordResetTokenJPARepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  UserDetailsServiceImpl userDetailsService;




    @Autowired
    private EmailServiceImpl emailService;

    public AuthenticationServiceImpl(MemberSecretJpaRepository secretJpaRepository, MemberJpaRepository memberJpaRepository, MemberRepository memberRepository, PasswordResetTokenJPARepository passwordResetTokenJPARepository, PasswordResetRepository resetRepository) {
        this.secretJpaRepository = secretJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberRepository = memberRepository;
        this.resetRepository = resetRepository;
        this.passwordResetTokenJPARepository = passwordResetTokenJPARepository;

    }

    @Transactional
    public String generateAndSendOtp(String emailAddress){
        // Check if any of the user in db has the email provided
        Member validUser = memberJpaRepository.findByEmailAddress(emailAddress);
        if (validUser == null ){
            throw  new MemberNotFoundException();
        }
        // if user is valid, generate random 6 digit otp
        String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
        System.out.println("Length of OTP: " +otp.length());
        // Send Token to user email address
        emailService.sendResetPasswordCode(emailAddress,otp);
        // save token sent to user in db
        PasswordResetTokenEntity tokenEntity = new PasswordResetTokenEntity();
//        tokenEntity.setId(UUID.randomUUID().toString());
        tokenEntity.setOtp(otp);
        resetRepository.saveOne(tokenEntity);
        System.out.println(String.format("Token sent to %s",emailAddress));
        return otp;

    }

    public boolean validateToken(String otp){
        PasswordResetTokenEntity validToken = passwordResetTokenJPARepository.findPasswordResetTokenEntitiesByOtp(otp);
        if(validToken.getOtp().equals(otp)){
            return true;
        }
        return false;

    }


    public String passwordReset(ResetPasswordDto dto) {
        boolean validatedToken = validateToken(dto.getToken());
        if(validatedToken) {
            Member member = memberJpaRepository.findByEmailAddress(dto.getEmailAddress());
            member.setPassword(dto.getPassword());
            setPassword(member);
            memberRepository.saveOne(member);
            return String.format("%s, password reset successful",member.getFirstName());

        }
        else{
            return String.format("%s, password reset failed, try again");
        }

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
