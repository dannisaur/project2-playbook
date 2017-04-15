package com.revature.kkoders.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GamePlan;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

@Component
public class GamePlanImplDAOImpl implements GamePlanImplDAO {

	@Override
	public List<GamePlanImpl> getGamePlanById(int user_id) {
		Session session = HibernateUtil.getSession();
		//GamePlanImpl user = (GamePlanImpl) session.get(GamePlanImpl.class, user_id);
		
		String hql = "FROM GamePlanImpl WHERE user.userID =:user_id";
		Query query = session.createQuery(hql);
		query.setParameter("user_id", user_id);
		List<GamePlanImpl> plan = query.list();
		return plan;
	}

	@Override
	public void setTitleForForm(String plan_name, int un ) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET title  =:title where uid =:USER_ID";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("title", plan_name);
		query.setParameter("uid", un);
		query.executeUpdate();
		
		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void setStartDate(String sd, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET startDate =:startdate where uid =:USER_ID";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("startdate", sd);
		query.setParameter("uid", un);
		query.executeUpdate();
		
		session.flush();
		t.commit();
		session.close();
	}

	@Override
	public void setEndDate(String ed, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =:endDate where uid =:USER_ID";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("endDate", ed);
		query.setParameter("uid", un);
		query.executeUpdate();
		
		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void ChangeEndDate(String c_ed, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =:endDate where uid =:USER_ID";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("endDate", c_ed);
		query.setParameter("uid", un);
		query.executeUpdate();
		
		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void setHoursByUser(double uh, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET hours =:hours where uid =:USER_ID";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("hours", uh);
		query.setParameter("uid", un);
		query.executeUpdate();
		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void CreateGamePlan(GamePlanImpl gm) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		session.save(gm);
		session.getTransaction();
		System.out.println("saving info");
		t.commit();
		session.close();
		
	}

}
