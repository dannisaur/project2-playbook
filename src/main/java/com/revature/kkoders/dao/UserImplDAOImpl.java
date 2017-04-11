package com.revature.kkoders.dao;

import com.revature.kkoders.hibernateUtil.HibernateUtil;
import com.revature.kkoders.beans.UserImpl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



public class UserImplDAOImpl implements UserImplDAO {

	public UserImpl getUserById(int userID) {
		Session session = HibernateUtil.getSession();
		UserImpl user = (UserImpl) session.get(UserImpl.class, userID);
		
		session.close();
		return user;
		
		
	}

	public void UpdatePasswordByUn(String password, String n) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET pw  =: pw where userName =: userName";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("pw", password);
		query.setParameter("userName", n);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdateEmailByUn(String email, String n) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET email =: email where userName =: userName";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("email", email);
		query.setParameter("userName", n);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdateDescriptionByUn(String descrip, String n) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET desc =: desc where userName =: userName";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("desc", descrip);
		query.setParameter("userName", n);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdatePictureByUn(String URL, String n) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET picURL =: picURL where userName =: userName";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("picURl", URL);
		query.setParameter("userName", n);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	@Override
	public void SignUpUser(String fn, String ln, String un, String p, String em, String picurl, String d) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		UserImpl newUser = new UserImpl();
		newUser.setFirstName(fn);
		newUser.setLastName(ln);
		newUser.setUserName(un);
		newUser.setPw(p);
		newUser.setEmail(em);
		newUser.setPicture(picurl);
		newUser.setDesc(d);
		
		session.save(newUser);
		session.getTransaction();
		t.commit();
		
		
	}

	

}
