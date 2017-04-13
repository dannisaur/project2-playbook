package com.revature.kkoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.UserDAOImpl;
import com.revature.kkoders.dao.UserImplDAOImpl;

@Component
public class UserService {

	@Autowired
	UserDAOImpl userDao;

	@Autowired
	UserImplDAOImpl userDAO;

	public void addUser(UserImpl newUser) {

		// DAO method
		userDAO.SignUpUser(newUser.getFirstName(), newUser.getLastName(), newUser.getUserName(), newUser.getPw(),
				newUser.getEmail(), newUser.getPicture(), newUser.getDesc());

		System.out.println("User added.");

	}

	public UserImpl auth(UserImpl usr) {
		if (userDao == null) {
			System.out.println("something??");
		}
		return userDao.validate(usr.getUserName(), usr.getPw());
	}
	
	//Adding Method to get all of the users information by username
	public UserImpl UsersInfo(String nn) {
		return userDAO.getUsersInfoByUsername(nn);
	}

}