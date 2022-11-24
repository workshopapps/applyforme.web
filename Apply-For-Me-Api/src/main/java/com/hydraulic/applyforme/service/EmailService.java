package com.hydraulic.applyforme.service;

import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    public void sendWelcomeMessage(String emailAddress);
    public String getByResetPasswordToken(String token);
    public void sendResetPasswordMail(String recipientEmail, String baseUrl);

    void signupVerification(String recipientEmail);

    public String createVerificationToken();

    public void sendSignUpVerificationEmail(String emailAddress, String memberCode);
}
