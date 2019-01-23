package com.csc340.backend.csc340;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@MessageMapping("/user")
	@SendTo("/topic/user")
	public User getUser(User user) {
		return user;
	}
}
