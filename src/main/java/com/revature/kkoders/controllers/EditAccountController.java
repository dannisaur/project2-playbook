package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/account/edit"})
public class EditAccountController {
	
	/**
	 * Brings up the edit account page of the user signed in.
	 * 
	 * Browses to the edit account page only if a user is signed in.
	 * Otherwise browses to the login page.
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String doEditAccount(HttpSession session) {
		//TODO: validate that user is logged in to display edit account page, otherwise send to login page.
		
		
		return "account/edit_account"; //TODO: only go to edit account page if signed in.
	}

}
