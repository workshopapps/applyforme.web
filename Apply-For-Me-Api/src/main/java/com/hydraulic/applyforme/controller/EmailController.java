package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.jpa.MemberJaRepository;
import com.hydraulic.applyforme.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
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
    private MemberJaRepository memberJaRepository;

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String email = request.getParameter("email");
        String token = emailService.createResetPasswordToken();
        String siteURL = request.getRequestURL().toString();
        String formattedURL = siteURL.replace(request.getServletPath(), "");
        String resetPasswordLink = formattedURL + "/reset_password?token=" + token;
        emailService.sendResetPasswordMail(email, resetPasswordLink);
        return "forgot_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String newpassword = request.getParameter("password");

        String savedpwdtoken = emailService.getResetPasswordToken();
        String savedemailaddress = emailService.getEmailAddress();

        if (savedpwdtoken.trim().equals(token.trim())){
            Member member = memberJaRepository.findByEmailAddress(savedemailaddress.trim());
             emailService.updatePassword(savedemailaddress, newpassword);
            return "You have successfully changed your password.";
        } else {
            return "Invalid Token";
        }
    }
}
