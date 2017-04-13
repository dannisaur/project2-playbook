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
<<<<<<< HEAD

	// PARAMETER NAME IS CALLED someInfo
	// REQUEST.GETPARAM('someInfo')
||||||| merged common ancestors
	
	//PARAMETER NAME IS CALLED someInfo
		//REQUEST.GETPARAM('someInfo')
=======


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
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
	@ModelAttribute("someInfo")
<<<<<<< HEAD
	public String addInfoToRequestScope() {
||||||| merged common ancestors
	public String addInfoToRequestScope()
	{
=======
	public String addInfoToRequestScope() //appends to the url like it's a GET request
	{
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
		System.out.println("Adding something to the modelmap");
		return "This is the info added";
	}
<<<<<<< HEAD

||||||| merged common ancestors
	
=======
	*/
	

>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
	/**
	 * Handles bringing up the login page.
	 * 
	 * @param modelMap
	 * @return
	 */
<<<<<<< HEAD
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) {
||||||| merged common ancestors
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
=======

	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap)
	{
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
		System.out.println(modelMap.get("someInfo"));
<<<<<<< HEAD
		System.out.println("This was a get request");
		modelMap.addAttribute("user", emptyUser);

		// RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		// LOGIN
		// SUFFIX: .jsp
||||||| merged common ancestors
		System.out.println("This was a get request");
		modelMap.addAttribute("user", emptyUser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp
=======
		System.out.println("GET request: /login");
		modelMap.addAttribute("user", emptyUser); 
		
		//RETURN LOGIN TO TAKE US TO PREFIX: WEB-INF
		//LOGIN
		//SUFFIX: .jsp

>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
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
<<<<<<< HEAD
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession session) {
		System.out.println("This was a post request");
		if (bindingResult.hasErrors()) {
||||||| merged common ancestors
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin( UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession seesion)
	{
		System.out.println("This was a post request");
		if(bindingResult.hasErrors())
		{
=======

	@RequestMapping(method=RequestMethod.POST)
	public String doLogin( UserImpl user, BindingResult bindingResult, ModelMap modelMap, HttpSession session)
	{
		System.out.println("POST request: /login");
		if(bindingResult.hasErrors())
		{
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
			System.out.println("errrors");
			return "login";
		}
		UserImpl authUser = userService.auth(user);
<<<<<<< HEAD
		if (authUser != null) {
			// TODO GET A USERS GAMES
			
			modelMap.addAttribute("user", userService.getUserInfoByUserName(user));
			session.setAttribute("alsoUser", userService.getUserInfoByUserName(user));
			// NEW VIEW
			return "account"; // the user was logged in.
		} else {
||||||| merged common ancestors
		if (authUser != null)
		{
			//TODO GET A USERS GAMES
			modelMap.addAttribute("user", user);
			seesion.setAttribute("alsoUser", user);
			//NEW VIEW
      return "account"; //the user was logged in.
		}
		else
		{
=======
    
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
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			modelMap.addAttribute("user", emptyUser);
			return "login";
		}
	}
}
