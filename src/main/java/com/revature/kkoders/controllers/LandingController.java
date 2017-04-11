package com.revature.kkoders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Redirects to the landing page of the application.
 * 
 */
@Controller
@RequestMapping(value={"/landing", "/**/landing"})
public class LandingController {
	
	/**
	 * Handles requests for the landing page in nested directories (e.g., account/landing).
	 * 
	 * If URL is in a nested directory, then requests for "/landing" cannot be properly resolved by 
	 * simply redirecting/forwarding to it and also have the browser display the correct URL.
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String doLanding() {
		System.out.println("POST request: /**/landing");
		
		return "redirect:/landing";
	}

	/**
	 * Handles requests for the landing page.
	 * 
	 * If URL is not a nested directory, then requests for "/landing" can be simply forwarded to display 
	 * the app's landing page and the browser will display the correct URL.
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getLandingPage() {
		System.out.println("GET request: /landing");
		
		return "forward:/index.jsp";
	}
	
}
