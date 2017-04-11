package com.revature.kkoders.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.GameLibraryDaoImpl;

@Component
public class GameLibService
{
	static GameLibraryDaoImpl gLDao = new GameLibraryDaoImpl();
	
	public List<GameImpl> getUsersGame(UserImpl me)
	{
		return gLDao.getGamesByUser(me);
	}
}
