package com.csc340.backend.csc340;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.csc340.backend.csc340.repository.ProfileRepository;

@EnableJpaRepositories(basePackageClasses = ProfileRepository.class)
@Configuration
public class SecurityConfiguration {

}
