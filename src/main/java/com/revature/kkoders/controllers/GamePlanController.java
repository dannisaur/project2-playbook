package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/gameplan")
public class GamePlanController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String doGameplan(HttpSession session) {
		System.out.println("GET request: /gameplan");
		
		//TODO: validate that user is logged in to display account page, otherwise send to login page.
		System.out.println("IN gameplan");
		return "gameplan"; //TODO: only goto account if signed in. 
	}
	

}
