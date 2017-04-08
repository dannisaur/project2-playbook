package com.revature.kkoders.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

public class GamePlanImplDAOImpl implements GamePlanImplDAO {

	@Override
	public GamePlanImpl getGamePlanById(int plan_id) {
		Session session = HibernateUtil.getSession();
		GamePlanImpl user = (GamePlanImpl) session.get(GamePlanImpl.class, plan_id);
		
		session.close();
		return user;
	}

	@Override
	public void setTitleForForm(String plan_name) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET title  =: title";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("title", plan_name);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	@Override
	public void setStartDate(String sd) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET startDate =: startdate";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("startdate", sd);
		query.executeUpdate();
		
		t.commit();
		session.close();
	}

	@Override
	public void setEndDate(String ed) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =: endDate";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("endDate", ed);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	@Override
	public void ChangeEndDate(String c_ed) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =: endDate";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("endDate", c_ed);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	@Override
	public void setHoursByUser(double uh) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET hours =: hours";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("hours", uh);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

}
