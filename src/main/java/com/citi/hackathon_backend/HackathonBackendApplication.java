package com.citi.hackathon_backend;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDynamoDBRepositories({"com.citi.hackathon_backend.event","com.citi.hackathon_backend.volunteerInfo","com.citi.hackathon_backend.org","com.citi.hackathon_backend.login"})
public class HackathonBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonBackendApplication.class, args);
	}

}
