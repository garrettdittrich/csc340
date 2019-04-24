package com.csc340.backend.csc340.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.csc340.backend.csc340.models.CustomUserDetailsImpl;
import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ProfileRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private ProfileRepository profileRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Profile profile = profileRepository.findByUsername(username);
		return new CustomUserDetailsImpl(profile);
	}

}
