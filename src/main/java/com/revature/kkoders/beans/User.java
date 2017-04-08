package com.revature.kkoders.beans;

//import org.springframework.stereotype.Component;

//@Component
public interface User {
	
	public void setUserID(int userID);
	public int getUserID();
	
	public void setFirstName(String firstName);
	public String getFirstName();
	
	public void setLastName(String lastName);
	public String getLastName();
	
	public void setUserName(String userName);
	public String getUserName();
	
	public void setPW(String pw);
	public String getPW();
	
	public void setEmail(String email);
	public String getEmail();
	
	public void setPicture(String picURL);
	public String getPicture();
	
	public void setDesc(String desc);
	public String getDesc();
	
	//public GameLibraryImpl getGameLib();

}
