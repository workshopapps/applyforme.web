package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.contactUs.ContactUsDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    public void sendWelcomeMessage(String emailAddress);
    public String getByResetPasswordToken(String token);
    public void sendResetPasswordMail(String recipientEmail, String baseUrl);

    void onboard(OnboardingResponse response, String onboardToken);

    void signupVerification(String recipientEmail,String otp);
    public String createVerificationToken();
    public void sendSignUpVerificationEmail(String emailAddress, String memberCode);
    public  void contactUs(ContactUsDto dto);
    public void sendResetPasswordCode(String recipientEmail, String code);
    void confirmRecruiter(CreateRecruiterDto dto);
    @Async
    void dummy();
}
