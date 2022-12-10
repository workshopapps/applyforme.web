package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.dto.authentication.ForgotPasswordDto;
import com.hydraulic.applyforme.model.dto.authentication.ResetPasswordDto;
import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;
import com.hydraulic.applyforme.model.exception.EmailDeliveryException;
import com.hydraulic.applyforme.model.exception.EmailNotFoundException;
import com.hydraulic.applyforme.model.exception.InvalidPasswordResetCodeException;
import com.hydraulic.applyforme.model.exception.InvalidResetTokenException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.service.AuthenticationService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private MemberSecretJpaRepository secretJpaRepository;
    private MemberJpaRepository memberJpaRepository;
    private MemberRepository memberRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Environment env;

    @Autowired
    private JavaMailSender javaMailSender;

    private MemberSecretJpaRepository memberSecretJpaRepository;

    public AuthenticationServiceImpl(MemberSecretJpaRepository secretJpaRepository, MemberJpaRepository memberJpaRepository, MemberRepository memberRepository, MemberSecretJpaRepository memberSecretJpaRepository) {
        this.secretJpaRepository = secretJpaRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberRepository = memberRepository;
        this.memberSecretJpaRepository = memberSecretJpaRepository;
        //this.javaMailSender = javaMailSender;
    }

    @Override
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

    private void setPassword(Member member) {
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

    @Override
    public void forgotPassword(ForgotPasswordDto forgotPasswordDto) {
        Member member = memberRepository.findByEmail(forgotPasswordDto);
        if (member != null ) {
            String resetPasswordCode = createResetPasswordCode();
            // Send resetPasswordCode  to database
            sendResetPasswordCode(forgotPasswordDto.getEmailAddress(), resetPasswordCode);
        } else {
            throw new EmailNotFoundException();
        }
    }

    private void sendResetPasswordCode(String recipientEmail, String code) {
        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<p>You have requested to reset your password.</p>" +
                "<p>Copy the code below to reset your password:</p>" +
                "<p>Your password reset code is: </p>" + code + "<br>" +
                "<p>Ignore this email if you do remember your password, " +
                "or you have not made the request.</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Reset Password Code";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("hngteamhydraulic@gmail.com");
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }
    }

    private String createResetPasswordCode() {
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9);
        }
        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
        return  code;
    }

    @Override
    public void matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto){
        String secretCode1 = memberSecretCodeDto.getFirstCode();
        String secretCode2 = memberSecretCodeDto.getSecondCode();
        String secretCode3 = memberSecretCodeDto.getThirdCode();
        String secretCode4 = memberSecretCodeDto.getFourthCode();

        String secretCode = secretCode1.trim() + secretCode2.trim() + secretCode3.trim() + secretCode4.trim();
        MemberSecretCode memberSecretCode = memberSecretJpaRepository.findBySignUpVerificationCode(secretCode);

        if(memberSecretCode == null) {
            throw new InvalidPasswordResetCodeException();
        }
    }

    /*
     * Although we already implemented use of link for password reset,I created this method
     * in-case we want to revert to use of password code, which is already included in the
     * member secret code table.
     * */


    @Override
    public String getByResetPasswordToken(String token) {
        return null;
    }

}
