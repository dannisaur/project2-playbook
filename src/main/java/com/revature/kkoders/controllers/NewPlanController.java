package com.revature.kkoders.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserGame;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.GamePlanService;

@Controller
@RequestMapping(value = { "/newgameplan" })
public class NewPlanController {

	@Autowired
	UserImpl currUser;
	
	@Autowired
	GamePlanService GPS;

	/*
	 * @Autowired GameImpl game;
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String viewNewPlan(@ModelAttribute("newGamePlan") GamePlanImpl gamePlan, ModelMap mm, HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.

		currUser = (UserImpl) session.getAttribute("alsoUser");
		Set<UserGame> allGames = currUser.getGameLib();
		List<GameImpl> usersGames = new ArrayList<>();
		for (UserGame x : allGames) {
			usersGames.add(x.getGame());
		}
		mm.addAttribute("currUser", currUser);
		mm.addAttribute("games", usersGames);

		return "/newgameplan";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitNewPlan(@ModelAttribute("newGamePlan") GamePlanImpl gamePlan, ModelMap mm,
			HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.

		UserImpl user = (UserImpl) session.getAttribute("alsoUser");

		GPS.GamePlanSet(gamePlan, user);

		return "/account";
	}

}