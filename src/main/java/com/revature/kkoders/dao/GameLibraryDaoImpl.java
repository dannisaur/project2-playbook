package com.revature.kkoders.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GameLibraryImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.util.HibernateUtil;

@Component
public class GameLibraryDaoImpl implements GameLibraryDao {

	static final Logger l = Logger.getRootLogger();
	@Autowired
	GameLibraryImpl myGames;
	
	@Override
	public List<GameImpl> getGamesByUser(UserImpl user) {
		Session session = HibernateUtil.getSession();
		Criteria cr = session.createCriteria(GameLibraryImpl.class);
		cr.add(Restrictions.eq("USER_ID", user.getUserID()));
		List<GameImpl> results =  cr.list();
		//session.pers
		session.close();
		return results;
	}

	@Override
	public List<UserImpl> getUsersByGame(GameImpl game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGameToUser(GameImpl game, UserImpl user) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		user.addGameToLibrary(game);
		//user.getGameLib().add(game);
		//user.setGameLibrary(user.getGameLib());
		for ( GameImpl games : user.getGameLib())
		{
			l.warn("GAMES IN LIST ===> " + games.getGameTitle() + " " + games.getGameLibID());
		}
		session.saveOrUpdate(user);
		t.commit();
		session.close();
	}

}
