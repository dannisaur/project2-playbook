package com.revature.kkoders.dao;

import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;

public interface DailySessionImplDAO {
	
	public double getHoursByGamePlanTitle(String t);
	public int getPlanBySessionId(int id);
	public void deleteSessionById(int ds_id);
	//public UserImpl getSessionByUser(String username);
	 

}
