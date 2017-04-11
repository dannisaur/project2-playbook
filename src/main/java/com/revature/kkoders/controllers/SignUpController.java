package com.revature.kkoders.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.UserDAOImpl;

@Controller
@RequestMapping(value = "/signup")

public class SignUpController {
	
	//ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

	@RequestMapping(method = RequestMethod.POST)
	public String processSignUp(@ModelAttribute("signupForm") UserImpl newUser, BindingResult br) {
		
		//UserDAOImpl userDAO = ac.getBean(UserDAOImpl.class);
		//userDAO.addOrUpdateUser(newUser);
		
		return "success";
	}

}
