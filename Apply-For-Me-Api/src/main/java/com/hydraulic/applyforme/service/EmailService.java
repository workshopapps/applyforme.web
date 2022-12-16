package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.contactUs.ContactUsDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    public void sendWelcomeMessage(String emailAddress);
    public String getByResetPasswordToken(String token);
    public void sendResetPasswordMail(String recipientEmail, String baseUrl);
    public void sendRegistrationMessageToRecruiter(String emailAddress, String password);
    @Async
    void onboard(OnboardingResponse response, String onboardToken);

    void signupVerification(String recipientEmail,String otp);
    String createVerificationToken();
    void sendSignUpVerificationEmail(String emailAddress, String memberCode);
    void contactUs(ContactUsDto dto);
    @Async
    void sendResetPasswordCode(String recipientEmail, String code);
    void confirmRecruiter(CreateRecruiterDto dto);
    @Async
    void dummy();
}
