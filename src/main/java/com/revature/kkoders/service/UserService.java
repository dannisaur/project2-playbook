package com.revature.kkoders.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.UserDAO;
import com.revature.kkoders.dao.UserDAOImpl;

//@Component
//@Transactional
public class UserService {
	
	
	//UserDAO userDao;
    
    public void addUser(){
        String firstname = "Danni";
        String lastname = "Tang";
        String username = "dtang";
        String password = "1234";
        String email = "dt1379@nyu.edu";
        
        UserImpl dummyUser = new UserImpl();
        
        dummyUser.setFirstName(firstname);
        dummyUser.setLastName(lastname);
        dummyUser.setUserName(username);
        dummyUser.setPW(password);
        dummyUser.setEmail(email);
        
        UserDAOImpl userDao = new UserDAOImpl();
        
        System.out.println("service adduser");
        
        // DAO method
        userDao.addOrUpdateUser(dummyUser);
    }


}