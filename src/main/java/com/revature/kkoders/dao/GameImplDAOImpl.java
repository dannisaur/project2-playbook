package com.revature.kkoders.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.kkoders.beans.GameImpl;
//import com.revature.kkoders.beans.GameLibraryImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

public class GameImplDAOImpl implements GameImplDAO {

	@Autowired
	GameImpl new_gl;
	
	@Override
	public GameImpl getGameById(int gl_id) {
		Session session = HibernateUtil.getSession();
		GameImpl users_gl = (GameImpl) session.get(GameImpl.class, gl_id);
		
		session.close();
		return users_gl;
		
	}

	@Override
	public void CreateGame(String gm_t, int st_id, int igDB_idm, String Rdate, String Platform) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		//GameImpl new_gl = new GameImpl();
		new_gl.setGameTitle(gm_t);
		new_gl.setSteamGameID(st_id);
		new_gl.setIgdbID(igDB_idm);
		new_gl.setReleaseDate(Rdate);
		new_gl.setPlatform(Platform);
		
		session.save(new_gl);
		session.getTransaction();
		t.commit();

	}

	@Override
	public Set<String> getAllPlatforms() {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT plt.platform from GameImpl as plt";
		Query query = session.createQuery(hql);
		
		Set<String> result = (Set<String>) query.list();
		session.close();
		return result;
	}

	@Override
	public Set<Integer> getSteamIds() {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT stid.steamGameID from GameImpl as stid";
		Query query = session.createQuery(hql);
		
		Set<Integer> result = (Set<Integer>) query.list();
		session.close();
		return result;
	}

	@Override
	public Set<Integer> getIgdbIds() {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT IGDB.igdbID from GameImpl as IGDB";
		Query query = session.createQuery(hql);
		
		Set<Integer> result = (Set<Integer>) query.list();
		session.close();
		return result;
	}

	@Override
	public Set<String> getAllGameTitles() {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT gt.gameTitle from GameImpl as gt";
		Query query = session.createQuery(hql);
		
		Set<String> result = (Set<String>) query.list();
		session.close();
		return result;
	}

	@Override
	public void RemoveGameTtle(String gm) {
		Session session = HibernateUtil.getSession();
		String hql = "DELETE from GameImpl where gameTitle =:gameTitle";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		query.setParameter("gameTitle", gm);
		query.executeUpdate();
		
		t.commit();
		session.close();
	}

	@Override
	public void RemoveReleaseDateByGameTitle(String gm) {
		Session session = HibernateUtil.getSession();
		String hql = "DELETE from GameImpl releasedate where gameTitle =:gameTitle";
		
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		query.setParameter("gameTitle", gm);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

}
