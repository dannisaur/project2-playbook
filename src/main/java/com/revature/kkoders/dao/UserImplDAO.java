package com.revature.kkoders.dao;

import com.revature.kkoders.beans.UserImpl;

public interface UserImplDAO {
	
	public UserImpl getUserById(int userID);
	//public void UpdateUserName(String newname);
	public void UpdatePassword(String password);
	public void UpdateEmail(String email);
	public void UpdateDescription(String descrip);
	public void UpdatePicture(String URL);
	public void SignUpUser(String fn, String ln, String un, 
			String p, String em, String picurl, String d );
	
	
	

}
