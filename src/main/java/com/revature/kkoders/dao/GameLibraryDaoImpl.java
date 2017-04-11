package com.revature.kkoders.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.util.HibernateUtil;

public class GameLibraryDaoImpl implements GameLibraryDao {

	@Override
	public ArrayList<GameImpl> getGamesByUser(UserImpl user) {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(GameImpl.class);
		cr.add(Restrictions.eq("user_id", user.getUserID()));
		ArrayList<GameImpl> results = (ArrayList<GameImpl>) cr.list();
		//session.pers
		
		return results;
	}

	@Override
	public ArrayList<UserImpl> getUsersByGame(GameImpl game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGameToUser(GameImpl game, UserImpl user) {
		// TODO Auto-generated method stub
		
	}
	
}
