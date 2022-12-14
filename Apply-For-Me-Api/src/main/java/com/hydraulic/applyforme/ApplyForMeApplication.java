package com.hydraulic.applyforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class ApplyForMeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApplyForMeApplication.class, args);
	}

}