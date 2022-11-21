package com.hydraulic.applyforme.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    public void sendWelcomeMessage(String emailAddress);
    public String getByResetPasswordToken(String token);
    public void sendResetPasswordMail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException;
    public String getEmailAddress();
    public String createResetPasswordToken();
    public String getResetPasswordToken();
    public void sendSignUpVerificationCode(String verificationCode, String emailAddress);

}
