package com.csc340.backend.csc340;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ProfileRepository;
import com.csc340.backend.csc340.repository.ProfileRepository;
import com.csc340.backend.csc340.models.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Csc340ApplicationTests {
//	@Autowired
//	private ProfileRepository profileRepository;
//	@Test
//	public void contextLoads() {
//		Profile bob = profileRepository.findByUsername("user");
//		long stuff = profileRepository.count();
//		System.out.println("*****************" + stuff + "*****************************");
//		//System.out.println(bob.getPassword());
//	}
	
	@Autowired
    ProfileRepository noteRepository;
	@Test
	public void bob() {
//		Optional<Profile> bob = noteRepository.findById(new Long(1));
//		System.out.println(bob.get().getPassword());
		Profile jim = noteRepository.findByUsername("garrett");
		System.out.println(jim.getPassword());
	}

}

