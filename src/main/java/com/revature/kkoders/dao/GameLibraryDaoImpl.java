package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GameLibraryImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.util.HibernateUtil;

public class GameLibraryDaoImpl implements GameLibraryDao {

	@Override
	public List<GameImpl> getGamesByUser(UserImpl user) {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(GameLibraryImpl.class);
		cr.add(Restrictions.eq("USER_ID", user.getUserID()));
		List<GameImpl> results =  cr.list();
		//session.pers
		
		return results;
	}

	@Override
	public List<UserImpl> getUsersByGame(GameImpl game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGameToUser(GameImpl game, UserImpl user) {
		// TODO Auto-generated method stub
		
	}
	
}
