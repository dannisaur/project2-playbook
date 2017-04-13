package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.UserService;

/**
 * Handles signing the user into the application.
 * 
 * @author 
 *
 */
@Controller
@RequestMapping(value="/login")
public class LoginController
{
	@Autowired
	UserImpl emptyUser;
	
	@Autowired
	UserService userService;
	
	//PARAMETER NAME IS CALLED someInfo
		//REQUEST.GETPARAM('someInfo')
	/*
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope() //appends to the url like it's a GET request
	{
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}
	*/
	
	/**
	 * Handles bringing up the login page.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
		//System.out.println(modelMap.get("someInfo"));
		System.out.println("GET request: /login");
		modelMap.addAttribute("user", emptyUser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp
		return "login";
	}
	
	/**
	 * Handles login details that were submitted.
	 * 
	 * @param user
	 * @param bindingResult
	 * @param modelMap
	 * @param seesion
	 * @return
	 * @throws Throwable 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin( UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession session)
	{
		System.out.println("POST request: /login");
		if(bindingResult.hasErrors())
		{
			System.out.println("errrors");
			return "login";
		}
		UserImpl authUser = userService.auth(user);
		
		if (authUser != null)
		{
			//TODO GET A USERS GAMES
			modelMap.addAttribute("user", user);
			session.setAttribute("alsoUser", user);
			//NEW VIEW
			return "redirect:/account"; //the user has successfully logged in, so take them to main account page. redirect in order to change url to "account".
		}
		else
		{
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			modelMap.addAttribute("user", emptyUser); 
			return "login";
		}
	}
}
