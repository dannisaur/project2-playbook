package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles signing the user out of the application.
 * 
 * @author 
 *
 */
@Controller
@RequestMapping(value={"/logout", "/doLogout"})
public class LogoutController {
	
	/**
	 * Signs the user out of the application.
	 * 
	 * Browses to the landing page of the app.
	 * 
	 * @param - 
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String doLogout(HttpSession session) {
		session.invalidate();
		
		return "landing";
	}

}
