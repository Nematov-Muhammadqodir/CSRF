package com.kevin.spring_security_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.spring_security_demo.model.User;
import com.kevin.spring_security_demo.service.MyUserDetailsService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityDemoApplication implements CommandLineRunner {

	final MyUserDetailsService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... params) throws Exception {
		User admin = new User();
		admin.setUserName("admin");
		admin.setPassword("admin");

		try {
			userService.signup(admin);
		} catch (Exception e) {
			System.out.println("User already exists, skipping...");
		}

		User client = new User();
		client.setUserName("client");
		client.setPassword("client");

		try {
			userService.signup(client);
		} catch (Exception e) {
			System.out.println("User already exists, skipping...");
		}
	}

}
