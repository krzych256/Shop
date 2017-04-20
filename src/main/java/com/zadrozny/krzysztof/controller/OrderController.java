package com.zadrozny.krzysztof.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class OrderController {
	
	@RequestMapping
	public String startOrder(@AuthenticationPrincipal User activeUser) {
				
		String userEmail = activeUser.getUsername();
		
		return "redirect:/order?usersEmail=" + userEmail;
	}
	
}
