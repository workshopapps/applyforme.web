package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(
    value = ""
)
public class HomeController {

    @ResponseBody
    @GetMapping
    public ApplyForMe home() {
        return new ApplyForMe();
    }
}
