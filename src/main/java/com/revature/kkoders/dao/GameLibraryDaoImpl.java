package com.revature.kkoders.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
		System.out.println("IN GETGAMESBYUSER GAMELIBRARYDAOIML");
		l.error("==================================================================================");
		Session session = HibernateUtil.getSession();
		String qry = "SELECT u.gameLibrary FROM UserImpl u JOIN u.gameLibrary gms WHERE u.userID =:usr ";
		Query q = session.createQuery(qry);
		q.setParameter("usr", user.getUserID());
		//q.list();
		
		//Criteria cr = session.createCriteria(UserImpl.class);
		//cr.add(Restrictions.eq("USER_ID", user.getUserID()));
		l.warn("----------------------------------- LIST RETURNED ---------------------------");
		l.warn(q.list().size()+ " SIZE ");
		System.out.println("testst");
//		List<Object[]> outs = q.list();
//		for(Object[] x : outs)
//		{
//			System.out.println("HERE");
//			l.warn(Arrays.toString(x) + ": OBJECT ");
//			int f = 0;
//			//l.warn((UserImpl)x+ ": OBJECT ");
//			//l.warn(((UserImpl)x).getUserName()+ " : USERNAME");
//		}
		List outs = q.list();
		for(int i =0; i < outs.size(); i++)
		{
			System.out.println("HERE");
			l.warn(outs.get(i).toString() + ": OBJECT ");
			int f = 0;
			//l.warn((UserImpl)x+ ": OBJECT ");
			//l.warn(((UserImpl)x).getUserName()+ " : USERNAME");
		}
		l.warn("----------------------------------- END LIST RETURNED ---------------------------");
		
		//List<GameImpl> results =  cr.list();
//		l.error("==================================================================================");
//		if(!q.list().isEmpty())
//		{
//			for (GameImpl x: (List<GameImpl>) q.list())
//			{
//				System.out.println(x.getGameTitle()+ " ===========================================");
//			}
//		}
		List<GameImpl> results = q.list();
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
