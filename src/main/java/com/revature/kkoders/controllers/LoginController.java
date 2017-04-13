package com.revature.kkoders.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.SteamApiDAOImpl;
import com.revature.kkoders.service.GameLibService;
import com.revature.kkoders.service.UserService;

/**
 * Handles signing the user into the application.
 * 
 * @author
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserImpl emptyUser;

	@Autowired
	UserService userService;


	// PARAMETER NAME IS CALLED someInfo
	// REQUEST.GETPARAM('someInfo')
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope() {
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}


	
	@Autowired
	GameLibService gameLibService;
	
	@Autowired
	SteamApiDAOImpl steamAPI;

	//PARAMETER NAME IS CALLED someInfo
		//REQUEST.GETPARAM('someInfo')
	/*
	@ModelAttribute("someInfo")
	public String addInfoToRequestScope() //appends to the url like it's a GET request
	{
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}
	*/
	

	/**
	 * Handles bringing up the login page.
	 * 
	 * @param modelMap
	 * @return
	 */

	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
		System.out.println(modelMap.get("someInfo"));
		System.out.println("GET request: /login");
		modelMap.addAttribute("user", emptyUser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp

		return "login";
	}

	/**
	 * Handles login details that were submitted.
	 * 
	 * @param user
	 * @param bindingResult
	 * @param modelMap
	 * @param seesion
	 * @return
	 * @throws Throwable 
	 */

	@RequestMapping(method=RequestMethod.POST)
	public String doLogin( UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession session)
	{
		System.out.println("POST request: /login");
		if(bindingResult.hasErrors())
		{
			System.out.println("errrors");
			return "login";
		}
		UserImpl authUser = userService.auth(user);
    
		if (authUser != null)
		{
      //get games
			List<GameImpl> myGames = new ArrayList<>();
			if(gameLibService.getUsersGame(authUser)== null || gameLibService.getUsersGame(authUser).isEmpty())
			{
				System.out.println("no games");
				if (authUser.getSteamId() != null && !authUser.getSteamId().isEmpty())
				{
				System.out.println(authUser.getSteamId());
					//GET THE USERS GAMES FROM STEAM
					try
					{
						steamAPI.getGames(authUser);
					} catch (SteamApiException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				myGames = gameLibService.getUsersGame(authUser);
				//ADD USERS GAMES TO A PARAMETER
			}
			

			//modelMap.addAttribute("user", user);
			//session.setAttribute("alsoUser", user);
      modelMap.addAttribute("user", userService.getUserInfoByUserName(user));
			session.setAttribute("alsoUser", userService.getUserInfoByUserName(user));
			//NEW VIEW
			return "redirect:/account"; //the user has successfully logged in, so take them to main account page. redirect in order to change url to "account".
		}
		else
		{
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			modelMap.addAttribute("user", emptyUser);
			return "login";
		}
	}
}
