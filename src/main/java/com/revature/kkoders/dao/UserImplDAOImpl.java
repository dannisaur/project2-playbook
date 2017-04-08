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

	public void UpdatePassword(String password) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET pw  =: pw";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("pw", password);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdateEmail(String email) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET email =: email";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("email", email);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdateDescription(String descrip) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET desc =: desc";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("desc", descrip);
		query.executeUpdate();
		
		t.commit();
		session.close();

	}

	public void UpdatePicture(String URL) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE UserImpl SET picURL =: picURL";
		Query query = session.createQuery(hql);
		
		Transaction t = session.beginTransaction();
		
		query.setParameter("picURl", URL);
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
