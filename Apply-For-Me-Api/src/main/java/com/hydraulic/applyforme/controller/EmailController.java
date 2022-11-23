package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.email.ResetPasswordDto;
import com.hydraulic.applyforme.model.exception.ResetPasswordInvalidTokenException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(
        value = "email",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;
    private final MemberRepository memberRepository;



    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "show forgot password form";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, @RequestParam ("email") final String emailAddress) throws MessagingException, UnsupportedEncodingException {
        String token = emailService.createResetPasswordToken();
        String siteUrl = request.getRequestURL().toString();
        String formattedUrl = siteUrl.replace(request.getServletPath(), "");
        String resetPasswordLink = formattedUrl + "/reset_password?token=" + token;
        emailService.sendResetPasswordMail(emailAddress, resetPasswordLink);
        return "show forgot password form";
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm(){
        return "show reset password form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(@Validated @RequestBody final ResetPasswordDto resetPasswordDto) {
        String token = resetPasswordDto.getToken();
        String newPassword = resetPasswordDto.getPassword();

        String savedPwdToken = emailService.getResetPasswordToken();
        String savedEmailAddress = emailService.getEmailAddress();

        if (savedPwdToken.trim().equals(token.trim())){
            memberRepository.updatePassword(savedEmailAddress, newPassword);
            return "You have successfully changed your password.";
        } else {
            throw  new ResetPasswordInvalidTokenException();
        }
    }
}

