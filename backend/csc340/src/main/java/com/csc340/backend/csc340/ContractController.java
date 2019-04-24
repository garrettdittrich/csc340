package com.csc340.backend.csc340;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ContractController {
	
	@MessageMapping("/proposals")
	@SendTo("/topic/proposals")
	public GpsUser getUser(GpsUser user) {
		System.out.println("Someone hit the /topic/contract endpoint");
		return user;
	}
}
