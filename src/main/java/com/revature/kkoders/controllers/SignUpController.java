package com.revature.kkoders.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.UserService;

@Controller
@RequestMapping(value = "/signup")

public class SignUpController {
	
	@Autowired
	UserService uService;
	
	@Autowired
	UserImpl newUser;
	
	//static ApplicationContext ac = new XmlWebApplicationContext();
	
	//  handles loading the sign up page
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getSignupPage(ModelMap model){
		//model.addAttribute("signupForm");
		return new ModelAndView("signup", "userImpl", newUser);
	}

	// handles the registration
	@RequestMapping(method = RequestMethod.POST)
	public String processSignUp(@ModelAttribute("userImpl") UserImpl userImpl, BindingResult br, ModelMap mm) {
		
		System.out.println(userImpl);
		uService.addUser(userImpl);
		
		return "success";
	}

}
