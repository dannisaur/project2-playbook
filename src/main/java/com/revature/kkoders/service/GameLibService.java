package com.revature.kkoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.GameImplDAOImpl;
import com.revature.kkoders.dao.GameLibraryDaoImpl;

@Component
public class GameLibService
{
	@Autowired
	GameImpl game;
	static GameLibraryDaoImpl gLDao = new GameLibraryDaoImpl();
	static GameImplDAOImpl gameDao= new GameImplDAOImpl();
	
	public List<GameImpl> getUsersGame(UserImpl me)
	{
		return gLDao.getGamesByUser(me);
	}
	
	public void addGame(UserImpl user, String gm_t, int st_id, int igDB_idm, String Rdate, String Platform)
	{
		game.setGameTitle(gm_t);
		System.out.println(gm_t);
		game.setSteamGameID(st_id);
		System.out.println(st_id);
		game.setReleaseDate(Rdate);
		System.out.println(Rdate);
		game.setPlatform(Platform);
		System.out.println(Platform);
		
		gameDao.CreateGame(game);
		System.out.println("Createdgmae");
		gLDao.addGameToUser(game, user);
		System.out.println("addedgametouser");
	}
}
