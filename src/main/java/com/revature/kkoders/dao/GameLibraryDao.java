package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;

public interface GameLibraryDao {
	
	List<GameImpl> getGamesByUser(UserImpl user);
	List<UserImpl> getUsersByGame(GameImpl game);
	
	void addGameToUser(GameImpl game, UserImpl user);
}
