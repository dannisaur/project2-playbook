package com.revature.kkoders.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.asynchttpclient.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.GamePlanImplDAOImpl;
import com.revature.kkoders.service.GamePlanService;
import com.revature.kkoders.controllers.*;

@Controller
@RequestMapping(value = "/gameplan")
public class GamePlanController {
	
	@Autowired
	UserImpl currUser;
	
	@Autowired 
	GamePlanImpl gmp;
	
	@Autowired
	GamePlanService GPS;
	

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView doGameplan(HttpSession session) {
		System.out.println("GET request: /gameplan");
		
		//TODO: validate that user is logged in to display account page, otherwise send to login page.
		System.out.println("IN gameplan");
		
		//currUser = (UserImpl) session.getAttribute("alsoUser");
		UserImpl user = (UserImpl) session.getAttribute("alsoUser");
		//GPS.GetPlansWithId(user.getUserID());
		
		List<GamePlanImpl> users_plan = GPS.GetPlansWithId(user.getUserID());
		//System.out.println(GPS.GetPlansWithId(currUser.getUserID()));
		ModelAndView mv = new ModelAndView("gameplan");
		mv.addObject("gameplans", users_plan);
		
		
		
		return mv; //TODO: only goto account if signed in.
		
	}
	

	
	
	
	
	

}
