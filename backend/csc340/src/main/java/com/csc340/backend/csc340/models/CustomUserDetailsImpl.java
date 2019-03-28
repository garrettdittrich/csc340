package com.csc340.backend.csc340.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.csc340.backend.csc340.models.Profile;

public class CustomUserDetailsImpl extends Profile implements UserDetails {
	private final Set<GrantedAuthority> authorities = new HashSet<>();
	public CustomUserDetailsImpl(final Profile profile) {
		super(profile);
		authorities.add(new SimpleGrantedAuthority("USER"));
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("USER"));
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
