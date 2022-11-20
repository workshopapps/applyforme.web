package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.email.ResetPasswordDto;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(
        value = "email",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        consumes = { MediaType.APPLICATION_JSON_VALUE }
)
public class EmailController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "forgot_password_form";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, @RequestParam ("email") final String emailAddress) throws MessagingException, UnsupportedEncodingException {
        String token = emailService.createResetPasswordToken();
        String siteURL = request.getRequestURL().toString();
        String formattedURL = siteURL.replace(request.getServletPath(), "");
        String resetPasswordLink = formattedURL + "/reset_password?token=" + token;
        emailService.sendResetPasswordMail(emailAddress, resetPasswordLink);
        return "forgot_password_form";
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm(){
        return "reset_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(@Valid final ResetPasswordDto resetPasswordDto) {
        String token = resetPasswordDto.getToken();
        String newpassword = resetPasswordDto.getPassword();

        String savedpwdtoken = emailService.getResetPasswordToken();
        String savedemailaddress = emailService.getEmailAddress();

        if (savedpwdtoken.trim().equals(token.trim())){
            emailService.updatePassword(savedemailaddress, newpassword);
            return "You have successfully changed your password.";
        } else {
            return "Invalid Token";
        }
    }
}

