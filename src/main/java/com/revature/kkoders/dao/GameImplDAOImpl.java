package com.revature.kkoders.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.kkoders.beans.GameImpl;
//import com.revature.kkoders.beans.GameLibraryImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

public class GameImplDAOImpl implements GameImplDAO {

	@Override
	public GameImpl getLibraryById(int gl_id) {
		Session session = HibernateUtil.getSession();
		GameImpl users_gl = (GameImpl) session.get(GameImpl.class, gl_id);
		
		session.close();
		return users_gl;
		
	}

	@Override
	public void CreateLibrary(String gm_t, int st_id, int igDB_idm, String Rdate, String Platform) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		GameImpl new_gl = new GameImpl();
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
		return null;
	}

	@Override
	public Set<Integer> getSteamIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Integer> getIgdbIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getAllGameTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void RemoveGameTtle(String gm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveReleaseDateByGameTitle(String gm) {
		// TODO Auto-generated method stub

	}

}
