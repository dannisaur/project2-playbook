package com.revature.kkoders.dao;

import java.util.ArrayList;

import com.revature.kkoders.beans.UserImpl;

public interface UserDAO {
    
    // insert
    public void addOrUpdateUser(UserImpl user);
    
//    // update
//    public void updateUser(UserImpl user);
    
    // read
    public UserImpl getUserByUsername(String username);
    public ArrayList<UserImpl> getAllUsers();
    public UserImpl validate (String uname, String pwd);
    // delete?
    

}