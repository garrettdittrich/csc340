package com.csc340.backend.csc340;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.csc340.backend.csc340.service.CustomUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//private final CustomUserDetailsService custUserService;
	
//	@Autowired
//	public SecurityConfig(CustomUserDetailsService cust) {
//		this.custUserService = cust;
//	}
	//@Override
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private CustomUserDetailsService userDetailServ;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailServ);
	    authProvider.setPasswordEncoder(getPasswordEncoder());
		auth.authenticationProvider(authProvider);
		//auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(getPasswordEncoder());
	}
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
					.antMatchers("/**").authenticated()
					.and().httpBasic();
	}
    private PasswordEncoder getPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
