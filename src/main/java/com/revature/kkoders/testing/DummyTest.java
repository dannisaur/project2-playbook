package com.revature.kkoders.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.ownedgames.Game;
import com.lukaspradel.steamapi.data.json.ownedgames.GetOwnedGames;
import com.lukaspradel.steamapi.data.json.playersummaries.GetPlayerSummaries;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetOwnedGamesRequest;
import com.lukaspradel.steamapi.webapi.request.GetPlayerSummariesRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

public class DummyTest {

	public static void main(String[] args) throws SteamApiException
	{
		        SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("1702897AF9585B3AEDABDB2C44075317").build();
		        
		        //GET ALL THE GAMES BUT ONLY ID
		        GetOwnedGamesRequest req = SteamWebApiRequestFactory.createGetOwnedGamesRequest("76561198146862839");
		        GetOwnedGames games =client.<GetOwnedGames> processRequest(req);
		        List<Integer> gameids = new ArrayList<Integer>();
		        for (Game x :games.getResponse().getGames())
		        {
		       // 	System.out.println(x.getAppid());
		        	gameids.add(x.getAppid());
		        }
		        
		        
		        List<String> userids = new ArrayList<String>();
		        userids.add("76561198146862839");
		        GetPlayerSummariesRequest req3 = SteamWebApiRequestFactory.createGetPlayerSummariesRequest(userids);
		        GetPlayerSummaries users =client.<GetPlayerSummaries> processRequest(req3);
		        System.out.println(users.getResponse());
		        
		        
		        
		       /* 
		        //GETS GAME NAME TOO BUT NEET TO POPULATE LIST
		        List<Integer> tst = new ArrayList<Integer>(); 
		        tst.add(433850);
		        GetOwnedGamesRequest req2 = SteamWebApiRequestFactory.createGetOwnedGamesRequest("76561198146862839",true,false, tst);
		        GetOwnedGames games2 =client.<GetOwnedGames> processRequest(req2);
		        
		        System.out.println(games2.getResponse());
		       */
		        
		        
		        
		        System.out.println("==============================================================================================");
		        
		        SteamApi steamApi = new SteamApi("US");

		            // Retrieves a list of all possible steam appIds along with name, in case you want to pre-check
		            //Map<Integer, String> appList = steamApi.listApps();

		            // Fetches information about the steam game including pricing
		            //SteamApp steamApp = steamApi.retrieve(433850); // by appId (exact match)
		            
		            //System.out.println(steamApp.getAboutTheGame());
		        	for (Integer y : gameids)
		        	{
		        		try 
		        		{
		        			SteamApp steamApp = steamApi.retrieve(y); // by appId (exact match)
		        //			System.out.println(steamApp.getAboutTheGame());
		        //			System.out.println("--------------------------------------------------------------------");
		        		} 
		        		catch (com.github.goive.steamapi.exceptions.SteamApiException e)
		        		{
		        			// TODO Auto-generated catch block
		        			//System.out.println("here");
		        		}
		        		
		            
		        	}
		            /*
		            // Use the getters to retrieve data or these convenience methods
		            steamApp.isFreeToPlay();
		            steamApp.isCheaperThan(15.99); // supports BigDecimal, Double and Integer
		            steamApp.isDiscounted();
		            steamApp.isDiscountedByAtLeast(20);
		            steamApp.isInAnyCategory("Single-player", "Multi-player");
		           */
		        System.out.println("==============================================================================================");

	}
}
