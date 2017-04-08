package com.revature.kkoders.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.util.HibernateUtil;

public class GameLibraryDaoImpl implements GameLibraryDao {

	@Override
	public ArrayList<GameImpl> getGamesByUser(UserImpl user) {
		/*
		Session session = HibernateUtil.getSession();
		String selectHql = "FROM GameImpl games INNER JOIN UserImpl users";
		Query selectQuery = session.createQuery(selectHql);
		
		ArrayList<GameImpl> games = (ArrayList<GameImpl>) selectQuery.list();
		*/
		
		//return user.getGameLib();
		
		return null;
	}

	@Override
	public ArrayList<UserImpl> getUsersByGame(GameImpl game) {
		
		Session session = HibernateUtil.getSession();
		String selectHql = "FROM UserImpl users INNER JOIN GameImpl games";
		Query selectQuery = session.createQuery(selectHql);
		
		ArrayList<UserImpl> users = (ArrayList<UserImpl>) selectQuery.list();
		
		return users;
		//return game.getUsers();
	}

	@Override
	public void addGameToUser(GameImpl game, UserImpl user) {
		// TODO Auto-generated method stub
		
	}
	
	

}
