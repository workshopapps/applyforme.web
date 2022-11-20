package com.hydraulic.applyforme.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Apply For Me",
                description = "You work at a remote company and you earn $1k a month. " +
                        "You are very happy. But you sometimes think - what if there are better jobs out there for me?" +
                        " But it's too much work to apply. " +
                        "In comes: ApplyForMe." +
                        " A service where you tell us your skills and what you are looking for, and people apply for you for 100s of jobs. All you need to do is attend interviews.",
                contact = @Contact(
                        email = "info@applyforme.com",
                        url = "applyforme.com",
                        name = "ApplyForMe"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/workshopapps/applyforme.web"
                )
        ),
        servers = @Server(url = "https://official-volunux.uc.r.appspot.com") // https://official-volunux.uc.r.appspot.com
)
public class OpenApiConfig {
}
