package com.csc340.backend.csc340;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Csc340Application {

	public static void main(String[] args) {
		SpringApplication.run(Csc340Application.class, args);
	}

}

