package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

    // since session.save will do both add and update
    public void addOrUpdateUser(UserImpl user) {
        // TODO Auto-generated method stub
        
    	System.out.println("userdao addorupdate");
    	
        // we get the current session
        Session currSession = HibernateUtil.getSession();
        
        // we start a transaction for this session
        Transaction currTx = currSession.beginTransaction();
        
        // in this session, we save a new user to the database
        currSession.save(user);
        
        // then we commit the transaction
        currTx.commit();

    }

//    public void updateUser(UserImpl user) {
//        // TODO Auto-generated method stub
//        
//    }

    public UserImpl getUserByUsername(String username) {
        // TODO Auto-generated method stub
        
        // we get the current session
        Session currSession = HibernateUtil.getSession();
        
        // we use a get method to eagerly fetch this object
        UserImpl user = (UserImpl) currSession.get(UserImpl.class, username);
        
        // then we return it
        return user;
    }

    public ArrayList<UserImpl> getAllUsers() {
        // TODO Auto-generated method stub
        
        // we get the current session
        Session currSession = HibernateUtil.getSession();
        
        // we make a criteria to list all the objects in the UserImpl class
        // save it to an ArrayList
        ArrayList<UserImpl> allUsers = (ArrayList) currSession.createCriteria(UserImpl.class).list();
        
        // return
        return allUsers;
    }

	@Override
	public UserImpl validate(String uname, String pwd)
	{
		UserImpl result = null;
        Session currSession = HibernateUtil.getSession();
        Criteria cr = currSession.createCriteria(UserImpl.class);
        Criterion chkName = Restrictions.eq("userName", uname);
        Criterion chkPwd = Restrictions.eq("pw", pwd);
     // To get records matching with AND conditions
        LogicalExpression andExp = Restrictions.and(chkName, chkPwd);
        cr.add(andExp);
        
        List rs = cr.list();
        if (rs.isEmpty() || rs.size() != 1)
        {
        	return result;
        }
        for (Object x : rs)
        {
        	result = (UserImpl)x;
        }
        System.out.println(result);
        return result;
	}

}