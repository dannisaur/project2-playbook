package com.revature.kkoders.dao;

import com.revature.kkoders.beans.GamePlanImpl;

public interface GamePlanImplDAO {
	
	public GamePlanImpl getGamePlanById(int plan_id);
	public void setTitleForForm(String plan_name, int un);
	public void setStartDate(String sd, int un);
	public void setEndDate(String ed, int un);
	public void ChangeEndDate(String c_ed, int un);
	public void setHoursByUser(double uh, int un);
	
	

}
