package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.UserImpl;

/**
 * Handles signing the user out of the application.
 * 
 * @author 
 *
 */
@Controller
@RequestMapping(value={"/logout", "/doLogout"})
public class LogoutController {
	@Autowired
	UserImpl emptyUser;
	
	/**
	 * Signs the user out of the application.
	 * 
	 * Browses to the landing page of the app.
	 * 
	 * @param - 
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String doLogout(HttpSession session, ModelMap modelMap) {
		modelMap.addAttribute("user", emptyUser); 
		session.invalidate();
		
		return "login";
	}

}
