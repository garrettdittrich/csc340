package com.csc340.backend.csc340;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csc340.backend.csc340.models.Profile;
import com.csc340.backend.csc340.repository.ContractRepository;
import com.csc340.backend.csc340.repository.ProfileRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContractTests {
	@Mock
    ContractRepository noteRepository;
	
	@Test
	public void testFindingContractById() {
		 Mockito.doReturn(new Contract()).when(noteRepository).save(new Contract());
		 Contract contr = noteRepository.save(new Contract());
		 assertEquals(contr.getActiveStatus(), false);
	}
	
	@Test
	public void testFindingByProposer() {
		 Mockito.doReturn(new Contract()).when(noteRepository).findByProposer(new Profile());
		 Contract contr = noteRepository.findByProposer(new Profile());
		 assertEquals(contr.getActiveStatus(), false);
	}
}
