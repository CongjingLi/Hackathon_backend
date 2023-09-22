package com.citi.hackathon_backend;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDynamoDBRepositories({"com.citi.hackathon_backend.event"})
public class HackathonBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonBackendApplication.class, args);
	}

}
