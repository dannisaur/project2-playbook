package com.revature.kkoders.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
		l.error("==================================================================================");
		Session session = HibernateUtil.getSession();
		//String qry = "SELECT u.gameLibrary FROM UserImpl u JOIN u.gameLibrary gms WHERE u.userID =:usr ";
		//Query q = session.createQuery(qry);
		//q.setParameter("usr", user.getUserID());
		
		
		String query = "SELECT G.* FROM GAME G INNER JOIN"
				+ 		" GAME_LIBRARY GL ON G.GAME_ID = GL.GAME_ID INNER JOIN"
				+ 		" USERS U ON U.USER_ID = GL.USER_ID "
				+ 		" AND U.USER_ID = :usr1";
		
		SQLQuery qerty = session.createSQLQuery(query);
		qerty.addEntity(GameImpl.class);
		qerty.setParameter("usr1", user.getUserID());
		List<GameImpl> test = qerty.list();
		for(GameImpl s : test)
		{
			System.out.println(s.getGameTitle());
		}
		//List<GameImpl> results = q.list();
		//session.pers
		session.close();
		//return results;
		
		return test;
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

	@Override
	public Map<Integer,GameImpl> getAllGames()
	{
		Session session = HibernateUtil.getSession();
		String query = "FROM GameImpl G";
		Query q = session.createQuery(query);
		List<GameImpl> output = q.list();
		Map<Integer,GameImpl> rets = new HashMap<>();
		for (GameImpl in : output)
		{
			rets.put(in.getSteamGameID(), in);
		}
		session.close();
		return rets;		
	}

}
