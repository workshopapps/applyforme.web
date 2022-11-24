package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.exception.EmailDeliveryException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.service.EmailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    private MemberJpaRepository memberJpaRepository;
    private MemberSecretJpaRepository memberSecretJpaRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailServiceImpl(MemberJpaRepository memberJpaRepository, MemberSecretJpaRepository memberSecretJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
        this.memberSecretJpaRepository = memberSecretJpaRepository;
    }

    @Async
    @Override
    public void sendWelcomeMessage(String emailAddress) {
        Member member = memberJpaRepository.findByEmailAddress(emailAddress);
        String messageSource = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\" https://firebasestorage.googleapis.com/v0/b/distro-55bdd.appspot.com/o/Distro%20Logo-05.png?alt=media&token=3e7f3e5b-471c-4565-b0b9-6bd0e0a5529d\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<b>Hey " + member.getFirstName() + ",</b>" + "<br>" +
                "<p>Welcome to ApplyForMe. We are thrilled to have you here!</p><br>" +
                "<p>ApplyForMe is a service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.</p>" +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Welcome to ApplyForMe";

        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(member.getEmailAddress());
            helper.setSubject(subject);
            helper.setText(messageSource, true);
            javaMailSender.send(msg);
        } catch (MessagingException ex2) {
            System.out.println("sendWelcomeMessage: " + ex2.getMessage());
        }
    }

    @Async
    @Override
    public void signupVerification(String emailAddress) {
        String token = createVerificationToken();

        String messageSource = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "Your sign up verification code is " + token +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";
        String subject = "Sign up verification";

        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(emailAddress);
            helper.setSubject(subject);
            helper.setText(messageSource, true);
            javaMailSender.send(msg);
        } catch (Exception exception) {
//            throw new EmailDeliveryException();
        }
    }

    @Override
    public String getByResetPasswordToken(String token) {
        return null;
    }

    @Async
    @Override
    public void sendResetPasswordMail(String recipientEmail, String baseUrl) {
        String link = baseUrl + "/reset-password?token=";
        String token = createVerificationToken();
        link += token;

        String messageSource = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<p>You have requested to reset your password.</p>" +
                "<p>Copy the code below to reset your password:</p>" +
                "<p><a href=\"" + link + "\">Change my password</a></p>" + "<br>" +
                "<p>Ignore this email if you do remember your password, " +
                "or you have not made the request.</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Reset Password Link";
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(messageSource, true);
            javaMailSender.send(msg);
        } catch (Exception exception) {
//            throw new EmailDeliveryException();
        }
    }

    @Override
    public String createVerificationToken() {
        return RandomString.make(30);
    }


    @Override
    public void sendSignUpVerificationEmail(String emailAddress, String memberCode){
        String messageSource = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "Your sign up verification code is " + memberCode +
                "<p> " +
                "</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Sign Up Verification Code";
        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(emailAddress);
            helper.setSubject(subject);
            helper.setText(messageSource, true);
            javaMailSender.send(msg);
        } catch (Exception exception) {
//            throw new EmailDeliveryException();
        }

    };
}