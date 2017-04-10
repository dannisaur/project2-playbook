package com.revature.kkoders.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.kkoders.beans.DailySessionImpl;
import com.revature.kkoders.beans.GamePlan;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

public class DailySessionImplDAOImpl implements DailySessionImplDAO {

	@Override
	public double getHoursByGamePlanTitle(String t) {
		Session sess = HibernateUtil.getSession();
		GamePlanImpl gmp = (GamePlanImpl) sess.get(GamePlan.class, t);
		
		double hours = gmp.getHoursPerDay();
		sess.close();
		return hours;
		
		
	}
	@Override
	public int getPlanBySessionId(int id) {
		Session session = HibernateUtil.getSession();
		DailySessionImpl user = (DailySessionImpl) session.get(DailySessionImpl.class, id);
		
		int sid = user.getDailySessionID();
		session.close();
		return sid;
	}

	@Override
	public void deleteSessionById(int ds_id) {
		Session sess = HibernateUtil.getSession();
		String hql = "DELETE from DailySessionImpl dailysessionID =: dailysessionID";
		Query query = sess.createQuery(hql);
		
		Transaction t = sess.beginTransaction();
		query.setParameter("dailysessionID", ds_id);
	}

	

}
