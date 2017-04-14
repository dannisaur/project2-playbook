package com.revature.kkoders.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;

@Controller
@RequestMapping(value = { "/link_steam" })
public class LinkSteamController {

	@Autowired
	UserImpl currUser;

	@Autowired
	GameImpl allGames;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doLibrary(HttpSession session) {
		ModelAndView model = new ModelAndView("/link_steam");

		currUser = (UserImpl) session.getAttribute("alsoUser");

		if (currUser.getSteamId().isEmpty()) {
			model.addObject("user", currUser);
			// link steam logic here
		} else {
			model.addObject("message", "You already linked your steam!");
		}

		return model;
	}

}
