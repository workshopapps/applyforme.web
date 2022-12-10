package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.contactUs.ContactUsDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    void sendWelcomeMessage(String emailAddress);
    void contactUs(ContactUsDto dto);
    void confirmRecruiter(CreateRecruiterDto dto);
    String createVerificationToken();
    void signupVerification(String emailAddress);
    //void sendResetPasswordMail(String recipientEmail, String baseUrl);
    void sendSignUpVerificationEmail(String emailAddress, String memberCode);

    @Async
    void dummy();
}
