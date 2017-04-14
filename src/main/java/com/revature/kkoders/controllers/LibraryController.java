package com.revature.kkoders.controllers;

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

@Controller
@RequestMapping(value = { "/library" })
public class LibraryController {
	
	@Autowired
	UserImpl currUser;
	
	@Autowired
	GameImpl allGames;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doLibrary(HttpSession session) {
		ModelAndView model = new ModelAndView("/library");

		currUser = (UserImpl) session.getAttribute("alsoUser");
		Set<UserGame> allGames = currUser.getGameLib();

		System.out.println(allGames.isEmpty());

		if (allGames.isEmpty()) {
			model.addObject("message", "You currently have no games in your Library.");
		} else {
			model.addObject("games", allGames);
		}
		model.addObject("user", currUser);

		return model;
	}

}
