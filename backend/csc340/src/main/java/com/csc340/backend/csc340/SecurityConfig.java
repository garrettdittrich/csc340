package com.csc340.backend.csc340;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.csc340.backend.csc340.service.CustomUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomUserDetailsService custUserService;
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService cust) {
		this.custUserService = cust;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
					.antMatchers("/**").hasRole("USER")
					.and().httpBasic();
	}
}
