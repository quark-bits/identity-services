package com.identity.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication authApp = new SpringApplication(AuthApplication.class);
		authApp.run(args);
	}

}
