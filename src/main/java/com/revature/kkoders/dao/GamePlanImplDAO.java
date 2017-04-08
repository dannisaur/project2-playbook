package com.revature.kkoders.dao;

import com.revature.kkoders.beans.GamePlanImpl;

public interface GamePlanImplDAO {
	
	public GamePlanImpl getGamePlanById(int plan_id);
	public void setTitleForForm(String plan_name);
	public void setStartDate(String sd);
	public void setEndDate(String ed);
	public void ChangeEndDate(String c_ed);
	public void setHoursByUser(double uh);
	
	

}
