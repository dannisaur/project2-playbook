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

import com.revature.kkoders.beans.User;

//KNOWS IT SHOULD HANDLE LOGIN REQUESTS
@Controller
@RequestMapping(value="/index")
public class LoginController
{
	@Autowired
	User emptyUser;
	
	//@Autowired
	//UserService userService;
	
	//PARAMETER NAME IS CALLED someInfo
		//REQUEST.GETPARAM('someInfo')
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope()
	{
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
		System.out.println(modelMap.get("someInfo"));
		System.out.println("This was a get request");
	//	modelMap.addAttribute("user", emptyuser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp
//		return "login";
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession seesion)
	{
		System.out.println("This was a post request");
		if(bindingResult.hasErrors())
		{
//			return "login";
			return "index";
		}
	/*	User authUser = userService.auth(user);
		if (authUser != null)
		{
			System.out.println(user.getUsername());
			modelMap.addAttribute("user", user);
			seesion.setAttribute("alsoUser", user);
			//NEW VIEW
			return "home";
		}
		else
		{
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			return "login";
		}*/
		return "index";
	}
}
