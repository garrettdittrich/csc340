package com.csc340.backend.csc340;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.csc340.backend.csc340.repository.ContractRepository;

@Controller
public class ContractController {
	@Autowired
	public ContractRepository contractRepo;
	
	@MessageMapping("/proposals")
	@SendTo("/topic/proposals")
	public GpsUser getUser(GpsUser user) {
		System.out.println("Someone hit the /topic/contract endpoint");
		return user;
	}
	
	@MessageMapping("/contract_by_id")
	@SendTo("/topic/contract_by_id")
	public AbstractContract getContractById(Contract user) {
		Optional<Contract> userFound = contractRepo.findById(user.getId());
		if (userFound.isPresent()) {
			return userFound.get();
		}
		return new NullContract();
	}
}
