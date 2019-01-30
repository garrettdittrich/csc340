//package com.csc340.backend.csc340.service;
//
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
//	}
//
//}
