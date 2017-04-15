package com.revature.kkoders.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserGame;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.SteamApiDAOImpl;
import com.revature.kkoders.service.UserService;

@Controller
@RequestMapping(value = { "/link_steam" })
public class LinkSteamController {

	@Autowired
	UserImpl currUser;
	
	@Autowired
	UserService service;

	@Autowired
	SteamApiDAOImpl steamAPI;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView linkSteamView(HttpSession session) {
		ModelAndView model = new ModelAndView("/link_steam");

		currUser = (UserImpl) session.getAttribute("alsoUser");
		System.out.println(currUser.getSteamId());
		
		if (currUser.getSteamId()!=null) {
			model.addObject("message", "You already linked your steam!");
		}

		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView linkSteam(HttpServletRequest request, HttpSession session) {

		ModelAndView model = new ModelAndView("/library");
		
		String id = request.getParameter("steamId");
		
		currUser = (UserImpl) session.getAttribute("alsoUser");
		
		// calling the add steam id method in the user service
		currUser = service.addSteamId(id, currUser);
		session.removeAttribute("alsoUser");
		session.setAttribute("alsoUser", currUser);
		
		Set<GameImpl> allGames = new HashSet<>();
		
		for (UserGame x : currUser.getGameLib()){
			allGames.add(x.getGame());
		}
		
		model.addObject("games", allGames);

		System.out.println("Printing steam id: " + currUser.getSteamId());
		
		return model;
	}

}
