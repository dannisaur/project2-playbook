package com.revature.kkoders.dao;

import java.util.ArrayList;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;

public interface GameLibraryDao {
	
	ArrayList<GameImpl> getGamesByUser(UserImpl user);
	ArrayList<UserImpl> getUsersByGame(GameImpl game);
	
	void addGameToUser(GameImpl game, UserImpl user);
}
