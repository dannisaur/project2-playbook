package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value={"/account"})
public class AccountController {
	
	/**
	 * Brings up the main account page of the user signed in.
	 * 
	 * Browses to the main account page only if a user is signed in.
	 * Otherwise browses to the login page.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String doAccount(HttpSession session) {
		System.out.println("GET request: /account");
		
		//TODO: validate that user is logged in to display account page, otherwise send to login page.
		System.out.println("IN ACCOUNT");
		return "account"; //TODO: only goto account if signed in. 
	}

}
