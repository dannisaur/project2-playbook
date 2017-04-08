package com.revature.kkoders.beans;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public interface User {
	
	public void setUserID(int userID);
	public int getUserID();
	
	public void setFirstName(String firstName);
	public String getFirstName();
	
	public void setLastName(String lastName);
	public String getLastName();
	
	public void setUserName(String userName);
	public String getUserName();
	
	public void setPw(String pw);
	public String getPw();
	
	public void setEmail(String email);
	public String getEmail();
	
	public void setPicture(String picURL);
	public String getPicture();
	
	public void setDesc(String desc);
	public String getDesc();
	
	//public GameLibraryImpl getGameLib();

}
