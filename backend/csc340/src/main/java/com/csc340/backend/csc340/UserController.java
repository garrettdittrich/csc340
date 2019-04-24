package com.csc340.backend.csc340;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@MessageMapping("/user")
	@SendTo("/topic/user")
	public GpsUser getUser(GpsUser user) {
		System.out.println("Someone hit the /topic/user endpoint");
		return user;
	}
	
	@MessageMapping("/incoming")
	@SendTo("/topic/incoming")
	public Contract incomingProposals(Contract contract) {
		System.out.println("Someone hit the /topic/incoming endpoint" + contract.getPaymentAmount());
		return contract;
	}
}
