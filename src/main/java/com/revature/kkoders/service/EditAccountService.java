package com.revature.kkoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.dao.UserImplDAOImpl;

@Component
public class EditAccountService {
	
	@Autowired
	UserImplDAOImpl userdao;
	
	@Autowired
	UserImpl currUser;
	
	//The following functions will update the account information
	//based on the user name
	
	
	public void checkNewpassword(String un, String pass){
		
		//checking if user is in the database
		if ( userdao.getUserByUserName(un)==null) {
			System.out.println("User is not in the database");
		}
		
		if ( pass.isEmpty() ) {
			System.out.println("You must put in a password");
		}
		
		else {
			userdao.UpdatePasswordByUn(pass, un);
		}
	}
	
	public void checkNewEmail(String un, String em){
		if ( userdao.getUserByUserName(un)==null) {
			System.out.println("User is not in the database");
		}
		
		else if ( em.isEmpty() ) {
			System.out.println("your new email can not be blank!!");
		}
		
		else {
			userdao.UpdateEmailByUn(em, un);
		}
		
	}
	
	//This function will check the path of the picture and upload it
	public void checkNewPicture(String un, String pic) {
		if ( userdao.getUserByUserName(un)==null) {
			System.out.println("User is not in the database");
		}
		
		else if ( pic.isEmpty() ) {
			System.out.println("you need to specify the path");
		}
		
		else {
			userdao.UpdatePictureByUn(un, pic);
		}
	}
	
	public void checkNewDescription(String un, String des) {
		if ( userdao.getUserByUserName(un)==null) {
			System.out.println("User is not in the database");
		}
		
		else if ( des.isEmpty() ){
			System.out.println("you descriptin can not be empty!!!");
		}
		
		else {
			userdao.UpdateDescriptionByUn(un, des);
		}
	}
	
	
	

}
