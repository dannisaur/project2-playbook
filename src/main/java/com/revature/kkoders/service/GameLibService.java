package com.revature.kkoders.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.GameImplDAOImpl;
import com.revature.kkoders.dao.GameLibraryDaoImpl;

@Component
public class GameLibService
{
	static final Logger l = Logger.getRootLogger();
	
	//@Autowired
	//GameImpl game;
	
	 @Autowired
	 private WebApplicationContext context;
	
	static GameLibraryDaoImpl gLDao = new GameLibraryDaoImpl();
	static GameImplDAOImpl gameDao= new GameImplDAOImpl();
	
	public List<GameImpl> getUsersGame(UserImpl me)
	{
		return gLDao.getGamesByUser(me);
	}
	
	public void addGame(UserImpl user, String gm_t, int st_id, int igDB_idm, String Rdate, String Platform)
	{
		GameImpl game = (GameImpl)context.getBean("gameImpl");
		game.setGameTitle(gm_t);
		game.setSteamGameID(st_id);
		game.setReleaseDate(Rdate);
		game.setPlatform(Platform);
		
		gameDao.CreateGame(game);
		gLDao.addGameToUser(game, user);
	}
}
