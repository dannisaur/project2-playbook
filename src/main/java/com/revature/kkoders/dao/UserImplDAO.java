package com.revature.kkoders.dao;

import com.revature.kkoders.beans.UserImpl;

public interface UserImplDAO {
	
	public UserImpl getUserById(int userID);
//	public UserImpl getUserByUserName(String newname);
	public void UpdatePasswordByUn(String password, String n);
	public void UpdateEmailByUn(String email, String n);
	public void UpdateDescriptionByUn(String descrip, String n);
	public void UpdatePictureByUn(String URL, String n);
	public void SignUpUser(String fn, String ln, String un, 
			String p, String em, String picurl, String d );
	
	//public UserImpl getUsersInfoByUsername(String userName);

}
