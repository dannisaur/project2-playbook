package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.service.GameLibService;

@Component
public class SteamApiDAOImpl
{
	@Autowired
	GameLibService gameLibService;
	
	public List<GameImpl> getGames (UserImpl user) throws SteamApiException
	{
		List<GameImpl> myGames = new ArrayList<>();
        SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("1702897AF9585B3AEDABDB2C44075317").build();
        
        //GET ALL THE GAMES BUT ONLY ID
        GetOwnedGamesRequest req = SteamWebApiRequestFactory.createGetOwnedGamesRequest(user.getSteamId());
        GetOwnedGames games =client.<GetOwnedGames> processRequest(req);
        List<Integer> gameids = new ArrayList<Integer>();
        
        //GET THE GAME IDS FROM STEAM
        for (Game x :games.getResponse().getGames())
        {
        //	System.out.println(x.getAppid());
        	gameids.add(x.getAppid());
        }
        System.out.println("==============================================================================================");
        
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
       			System.out.println("Game Name:");
       			String name = steamApp.getName();
       			System.out.println(name);
       			System.out.println("Release Date: ");
       			Date date = steamApp.getReleaseDate();
       			if (date !=null)
       			{
       				String[] todate = date.toString().split(" ");
       				gameLibService.addGame(user, name, y, 0, todate[1]+" "+ todate[2] +", "+ todate[todate.length-1], "PC");
       				System.out.println(todate[1]+" "+ todate[2] +", "+ todate[todate.length-1]);
       			}
       		} 
        	catch (com.github.goive.steamapi.exceptions.SteamApiException e)
        	{
        		// TODO Auto-generated catch block
        		//System.out.println("here");
       		}
       	}
        System.out.println("==============================================================================================");
		return null;
	}

}
