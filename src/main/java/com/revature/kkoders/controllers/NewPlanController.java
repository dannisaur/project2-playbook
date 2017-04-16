package com.revature.kkoders.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserGame;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.GameLibService;
import com.revature.kkoders.service.GamePlanService;

@Controller
@RequestMapping(value = { "/newgameplan" })
public class NewPlanController {

	@Autowired
	UserImpl currUser;
	
	@Autowired
	GamePlanService GPS;
	
	@Autowired
	GameLibService gameLibService;
	
	@Autowired
	GamePlanImpl ePlan;

	/*
	 * @Autowired GameImpl game;
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String viewNewPlan(GamePlanImpl gamePlan, ModelMap mm, HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.

		currUser = (UserImpl) session.getAttribute("alsoUser");
		Set<UserGame> allGames = currUser.getGameLib();
		List<GameImpl> usersGames = new ArrayList<>();
		//for (UserGame x : allGames) {
		//	usersGames.add(x.getGame());
		//}
		//=========================================================
		for ( GameImpl x: gameLibService.getUsersGame(currUser))
		{
			usersGames.add(x);
		}
		//========================================================
		mm.addAttribute("currUser", currUser);
		mm.addAttribute("games", usersGames);
		mm.addAttribute("newGamePlan", ePlan);

		return "/newgameplan";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitNewPlan(GamePlanImpl gamePlan, BindingResult bR, ModelMap mm,
			HttpSession session) {
		// TODO: validate that user is logged in to display edit account page,
		// otherwise send to login page.
		mm.addAttribute("newGamePlan", gamePlan);
		UserImpl user = (UserImpl) session.getAttribute("alsoUser");

		GPS.GamePlanSet(gamePlan, user);

		return "/account";
	}

}