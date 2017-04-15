package com.revature.kkoders.dao;

import java.util.List;
import java.util.Map;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;

public interface GameLibraryDao {
	
	List<GameImpl> getGamesByUser(UserImpl user);
	List<UserImpl> getUsersByGame(GameImpl game);
	
	void addGameToUser(GameImpl game, UserImpl user, Integer hour);
	Map<Integer,GameImpl> getAllGames();
}
