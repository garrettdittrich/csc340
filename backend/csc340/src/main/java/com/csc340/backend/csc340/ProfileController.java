package com.csc340.backend.csc340;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ContractRepository;
import com.csc340.backend.csc340.repository.ProfileRepository;

@Controller
public class ProfileController {
	@Autowired
	public ProfileRepository profileRepo;
	
	@RequestMapping(value = "/profile_lookup", method = RequestMethod.POST)
	public Profile profileLookup(@RequestBody Profile profile) {
		Profile foundProfile = profileRepo.findByUsername(profile.getUsername());
		return foundProfile;
	}
}
