package com.revature.kkoders.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;

@Controller
@RequestMapping(value = { "/newgameplan" })
public class NewPlanController {

	@Autowired
	UserImpl currUser;
	
	/*@Autowired
	GameImpl game;*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewNewPlan(@ModelAttribute("newGamePlan") GamePlanImpl gamePlan, ModelMap mm, HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.

		currUser = (UserImpl) session.getAttribute("alsoUser");
		List<GameImpl> usersGames = currUser.getGameLib();
		mm.addAttribute("currUser", currUser);
		mm.addAttribute("games", usersGames);

		return "/newgameplan"; 
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitNewPlan(@ModelAttribute("newGamePlan") GamePlanImpl gamePlan, ModelMap mm, HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.

//		currUser = (UserImpl) session.getAttribute("alsoUser");
//		List<GameImpl> usersGames = currUser.getGameLib();
//		mm.addAttribute("currUser", currUser);
//		mm.addAttribute("games", usersGames);

		return "/newgameplan"; 
	}

}