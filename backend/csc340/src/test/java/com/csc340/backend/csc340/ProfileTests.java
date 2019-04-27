package com.csc340.backend.csc340;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ProfileRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProfileTests {
	@Mock
    ProfileRepository profileRepository;
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindingContractById() {
		Mockito.doReturn(new Profile()).when(profileRepository).save(new Profile());
		Profile profile = profileRepository.save(new Profile());
		Mockito.doReturn("user").when(profile).getUsername();
		assertEquals(profile.getUsername(), "user");
	}
}
