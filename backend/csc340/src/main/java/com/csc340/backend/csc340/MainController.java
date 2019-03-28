package com.csc340.backend.csc340;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ProfileRepository;

@RequestMapping("/rest/")
@RestController
public class MainController {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/login")
	public SuccessObject helloWorld() {
		return new SuccessObject();
	}
	@GetMapping("/secured")
	public String secured() {
		return "should be a secured route";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody Profile profile) {
		Profile encodedProfile = profile;
		String encodedPassword = encoder.encode(profile.getPassword());
		encodedProfile.setPassword(encodedPassword);
		profileRepository.save(encodedProfile);
		return "Success";
	}
}
