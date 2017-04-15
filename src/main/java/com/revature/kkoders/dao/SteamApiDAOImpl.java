package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.ownedgames.Game;
import com.lukaspradel.steamapi.data.json.ownedgames.GetOwnedGames;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetOwnedGamesRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserGame;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.GameLibService;

@Component
public class SteamApiDAOImpl
{
	@Autowired
	GameLibService gameLibService;
	
	@Autowired
	GameLibraryDaoImpl gLDao;
	
	@Autowired
	GameImpl newGame;
	
	@Autowired
	UserGame userGame;
	
	public Set<UserGame> getGames (UserImpl user) throws SteamApiException
	{
		Set<UserGame> myGames = new HashSet<>();
        SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("1702897AF9585B3AEDABDB2C44075317").build();
        
        Map<Integer,GameImpl> dbGames = gLDao.getAllGames();
        Map<Integer,Integer> hours =  new HashMap<>();
        
        //GET ALL THE GAMES BUT ONLY ID
        GetOwnedGamesRequest req = SteamWebApiRequestFactory.createGetOwnedGamesRequest(user.getSteamId());
        GetOwnedGames games =client.<GetOwnedGames> processRequest(req);
        List<Integer> gameids = new ArrayList<Integer>();
        
        System.out.println("HERERERERRERRER");
        //GET THE GAME IDS FROM STEAM
        for (Game x :games.getResponse().getGames())
        {
        	hours.put(x.getAppid(), x.getPlaytimeForever()/60);
        	System.out.println(x.getPlaytimeForever());
        	if(dbGames.containsKey(x.getAppid()))
        	{        		
        		System.out.println("ALREADY HERE ");
        		gLDao.addGameToUser(dbGames.get(x.getAppid()), user, hours.get(x.getAppid()));
        		
        		userGame.setUser(user);
        		userGame.setGame(dbGames.get(x));
        		userGame.setHours(hours.get(x.getAppid()));
        		
        		myGames.add(userGame);
        	}
        	else
        	{
        		gameids.add(x.getAppid());
        	}
        }
        //CHANGED IT TO EU BECAUSE THE API CAN ONLY HANDLE EU DATE FORMATS
        SteamApi steamApi = new SteamApi("EU");

        //FOR EACH OF THE GAME IDS 
        	//GET THE GAME NAME
        	//RELEASE DATE
        //IF IT DOESNT EXIST JUST SKIP IT
        for (Integer y : gameids)
        {
        	try 
        	{
       			SteamApp steamApp = steamApi.retrieve(y); // by appId (exact match)
       			String name = steamApp.getName();
       			Date date = steamApp.getReleaseDate();
        		newGame.setGameTitle(name);
        		newGame.setPlatform("PC");
        		newGame.setSteamGameID(y);
        		newGame.setPic(steamApp.getHeaderImage());
       			if (date !=null)
       			{
       				String[] todate = date.toString().split(" ");
       				String crrctDate = todate[1]+" "+ todate[2] +", "+ todate[todate.length-1];
       				newGame.setReleaseDate(crrctDate);
     				gameLibService.addGame(user, name, y, 0, todate[1]+" "+ todate[2] +", "+ todate[todate.length-1], "PC", steamApp.getHeaderImage(), hours.get(y));
       			}
       			else
       				newGame.setReleaseDate("N/A");
       			
       			userGame.setUser(user);
        		userGame.setGame(newGame);
        		userGame.setHours(hours.get(y));
        		
        		myGames.add(userGame);
       			
       		} 
        	catch (com.github.goive.steamapi.exceptions.SteamApiException e)
        	{
        		// TODO Auto-generated catch block
        		//System.out.println("here");
       		}
       	}
		return myGames;
	}

	/**
	 * Gets the total playtimes a given user has for each given game.
	 * 
	 * The given games should be games the user owns.
	 * 
	 * @param user
	 * @param gamesInPlan
	 * @return the total playtimes the user has for each given game
	 * @throws SteamApiException
	 */
	public List<Integer> getPlaytimes(UserImpl user, List<GameImpl> gamesInPlan) {
		
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("1702897AF9585B3AEDABDB2C44075317").build();
        
        //GET ALL THE GAMES THE USER HAS (BUT ONLY ID), for comparison against the given games
        GetOwnedGamesRequest req = SteamWebApiRequestFactory.createGetOwnedGamesRequest(user.getSteamId());
        GetOwnedGames gamesOwnedRequest = null;
		try {
			gamesOwnedRequest = client.<GetOwnedGames> processRequest(req);
		} catch (SteamApiException e) {
			System.err.println("EXCEPTION GETTING GAMES OWNED BY USER");
			e.printStackTrace();
		}
        
        List<Integer> playtimes = new ArrayList<Integer>();
        
        //GET THE GAME PLAYTIMES FROM STEAM (GET PLAYTIME ONLY IF GAME IS ONE OF THE GIVEN GAMES)
        List<Game> gamesOwned = gamesOwnedRequest.getResponse().getGames();
        
        for (int i = 0; i < gamesOwned.size(); i++) {
        	Game steamGame = gamesOwned.get(i);
        	
        	// get playtime only if the current game is one of the given games
        	for (GameImpl playbookGame : gamesInPlan) {
        		if (steamGame.getAppid() == playbookGame.getSteamGameID()) {
        			playtimes.add(steamGame.getPlaytimeForever());
        		}
        	}
        }
		
		return playtimes;
	}

}
