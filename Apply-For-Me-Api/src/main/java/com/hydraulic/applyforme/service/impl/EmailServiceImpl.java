package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.contactUs.ContactUsDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.exception.EmailDeliveryException;
import com.hydraulic.applyforme.model.exception.PrivacyPolicyException;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberSecretJpaRepository;
import com.hydraulic.applyforme.service.EmailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@PropertySource(value = "classpath:application.properties")
@Configuration
public class EmailServiceImpl implements EmailService {
    private MemberJpaRepository memberJpaRepository;

    private MemberSecretJpaRepository memberSecretJpaRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public EmailServiceImpl(MemberJpaRepository memberJpaRepository, MemberSecretJpaRepository memberSecretJpaRepository, JavaMailSender mailSender) {
        this.memberJpaRepository = memberJpaRepository;
        this.memberSecretJpaRepository = memberSecretJpaRepository;
        this.javaMailSender = mailSender;
    }

    @Override
    public void sendWelcomeMessage(String emailAddress) {
        Member member = memberJpaRepository.findByEmailAddress(emailAddress);
        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"/\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<b>Hey " + member.getFirstName() + ",</b>" + "<br>" +
                "Welcome to ApplyForMe. We are thrilled to have you here!" + "<br>" +
                "ApplyForMe is a service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.</p>" +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Welcome to ApplyForMe";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(emailAddress);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }
    }

    @Override
    @Async
    public void onboard(OnboardingResponse response, String onboardToken) {
        String link = "https://applyforme.hng.tech/onboarding/" + onboardToken + "/complete";
        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"/\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<b>Hi " + response.getFirstName() + " " + response.getLastName() + ",</b>" + "<br>" +
                "<b>You can continue with your on-boarding through " +
                " <a href=\"" + link + "\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\">Complete onboarding</a>" +
                "Welcome to ApplyForMe. We are thrilled to have you here!" + "<br>" +
                "ApplyForMe is a service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.</p>" +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Welcome to ApplyForMe, Complete your on-boarding";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(response.getEmailAddress());
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("Error sending email");
        }
    }

    @Override
    public void signupVerification(String emailAddress,String otp) {
        String token = createVerificationToken();

        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
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
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(emailAddress);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }


    }

    @Override
    public String getByResetPasswordToken(String token) {
        return null;
    }

    @Override
    public void sendResetPasswordMail(String recipientEmail, String baseUrl) {
        String link = baseUrl + "/reset-password?token=";
        String token = createVerificationToken();
        link += token;

        String subject = "Reset Password";

        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "You have requested to reset your password." +
                "<p>Copy the code below to reset your password:</p>" + "<br>" +
                "<a href=\"" + link + "\">Change my password</a>" + " or use " + token + " in the form input field <br>" +
                "Ignore this email if you do remember your password, " +
                "or you have not made the request.</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }

    }

    @Override
    public String createVerificationToken() {
        return RandomString.make(10);
    }


    @Override
    public void sendSignUpVerificationEmail(String emailAddress, String memberCode){
        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "Your sign up verification code is " + memberCode +
                "</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Sign Up Verification Code";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(emailAddress);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }


    }


    @Override
    public void contactUs(ContactUsDto dto) {
        String senderEmail = dto.getEmailAddress();
        boolean privacyPolicyStatus = dto.getPrivacyPolicy();

        if (!privacyPolicyStatus) {
            throw new PrivacyPolicyException();
        }

        String subject = "Contact Us Message Details";

        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">"
                + "Sender's firstname: " + dto.getFirstName() + "<br>"
                + "Sender's lastname: " + dto.getLastName() + "<br>"
                + "Sender's email: " + dto.getEmailAddress() + "<br>"
                + "Message: " + dto.getMessage() + "<br>"
                + "Read privacy policy: " + dto.getPrivacyPolicy()
                + "</p>"+
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(senderEmail);
            helper.setTo(env.getProperty("applyforme.email"));
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }
    }

    /*
    * This is an alternative mail for password reset
    * */

    @Override
    @Async
    public void sendResetPasswordCode(String recipientEmail, String code) {

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
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }

    }
    
    @Override
	public void sendRegistrationMessageToRecruiter(String emailAddress, String password) {
		
		 Member member = memberJpaRepository.findByEmailAddress(emailAddress);
	        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
	                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
	                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
	                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"/\" /></a>" +
	                "<p>ApplyForMe</p>" +
	                "</div>" +
	                "<p style=\"font-size:1.1em\">" +
	                "<b>Hello " + member.getFirstName() + ",</b>" + "<br>" +
	                "Welcome to ApplyForMe. We are thrilled to have you here!" + "<br>" +
	                "ApplyForMe is a service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.</p>" +
	                "<p style=\"font-size:1.1em\">As a registered recruiter, here are your login details </p>"+
	                "<li style=\"font-size:1em\">"+"Email Address: "+ member.getEmailAddress()+ "</li>"+
	                "<li style=\"font-size:1em\">"+"Password: "+ password+ "</li>"+
	                "<p>you can always change your credentials at your wish in your profile settings. Welcome onboard </p>"+"<br>"+
	                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
	                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
	                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
	                " </div>" +
	                "</div>" +
	                "</div>";

	        String subject = "Welcome to ApplyForMe";
	        try {
	            MimeMessage message = javaMailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setFrom(env.getProperty("applyforme.email"));
	            helper.setTo(emailAddress);
	            helper.setSubject(subject);
	            helper.setText(content, true);
	            javaMailSender.send(message);
	        } catch (MessagingException e) {
	            throw new EmailDeliveryException();
	        }
		
		
	}

    @Override
    public void confirmRecruiter(CreateRecruiterDto member) {
        String content = " <div style=\"min-width:1000px;overflow:auto;line-height:2\">" +
                " <div style=\"margin:50px auto;width:50%;padding:20px 0\">" +
                "<div style=\"font-family:Helvetica,Arial,sans-serif;display:flex;border-bottom:1px solid #eee;font-size:1.2em;\">" +
                " <a href=\"\" style=\"margin-right: 5px;color: #00466a;text-decoration:none;font-weight:600\"><img style=\"height:55px; width:55px\" src=\"/\" /></a>" +
                "<p>ApplyForMe</p>" +
                "</div>" +
                "<p style=\"font-size:1.1em\">" +
                "<b>Hey " + member.getFirstName() + member.getLastName() + ",</b>" + "<br>" +
                "Welcome to ApplyForMe. We are thrilled to have you here!" + "<br>" +
                "ApplyForMe is a service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.</p>" +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                "<p>You are a now a recruiter and your email address is " + member.getEmailAddress() + " and your password is " + member.getPassword() + ".</p>" +
                " <hr style=\"border:none;border-top:1px solid #eee\" />" +
                "<div style=\"margin-top: 20px;padding:8px 0;color:#aaa;font-size:1.0em;line-height:1;font-weight:300\">" +
                " <p>© 2022 ApplyForMe, All rights reserved.</p>" +
                " </div>" +
                "</div>" +
                "</div>";

        String subject = "Welcome to ApplyForMe";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo(member.getEmailAddress());
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }
    }

    @Override
    public void dummy() {
        String content = "Hello World";
        String subject = "Sign up verification";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(env.getProperty("applyforme.email"));
            helper.setTo("volunux@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new EmailDeliveryException();
        }


    }

}