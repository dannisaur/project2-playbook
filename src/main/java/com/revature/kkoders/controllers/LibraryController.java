package com.revature.kkoders.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserGame;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.SteamApiDAOImpl;
import com.revature.kkoders.service.GameLibService;


@Controller
@RequestMapping(value = { "/library" })
public class LibraryController {

	@Autowired
	UserImpl currUser;

	@Autowired
	GameImpl allGames;

	@Autowired
	GameLibService gameLibService;

	@Autowired
	SteamApiDAOImpl steamAPI;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doLibrary(HttpSession session) {
		ModelAndView model = new ModelAndView("/library");

		currUser = (UserImpl) session.getAttribute("alsoUser");
		Set<UserGame> allGamesJoint = currUser.getGameLib();
		List<GameImpl> allGames = new ArrayList<>();
		//for (UserGame x : allGamesJoint)
		//{
		//	allGames.add(x.getGame());
		//}
		//=========================================================
		for ( GameImpl x: gameLibService.getUsersGame(currUser))
		{
			allGames.add(x);
		}
		//=========================================================

		System.out.println(allGames.isEmpty());

		if (allGames.isEmpty()) {
			model.addObject("message",
					"You currently have no games in your Library. <a href='link_steam'>Link your steam account now?</a>");
		} else {

			model.addObject("games", allGames);
		}
		model.addObject("user", currUser);

		return model;
	}

}
