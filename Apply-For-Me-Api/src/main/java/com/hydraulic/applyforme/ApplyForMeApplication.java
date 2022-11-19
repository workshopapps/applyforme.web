package com.hydraulic.applyforme;

import com.hydraulic.applyforme.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ApplyForMeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApplyForMeApplication.class, args);
	}

}
