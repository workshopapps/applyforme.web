package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
import com.hydraulic.applyforme.model.dto.contactUs.ContactUsDto;
import com.hydraulic.applyforme.service.EmailService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "contactUs",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ContactUsController {
    public final EmailService emailService;

    public ContactUsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/contact-us")
    public void contactUsMessage(@Validated @RequestBody ContactUsDto contactUsDto){
        emailService.sendContactUsMessageDetails(contactUsDto);
    }
}
