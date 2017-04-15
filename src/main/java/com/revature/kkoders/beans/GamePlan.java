package com.revature.kkoders.beans;

import org.springframework.stereotype.Component;

@Component
public interface GamePlan {
	
	public void setPlanID(int planID);
	public int getPlanID();
	
	public void setTitle(String title);
	public String getTitle();
	
	public void setStartDate(String startDate);
	public String getStartDate();
	
	public void setEndDate(String endDate);
	public String getEndDate();
	
	public void setHours(double hours);
	public double getHours();
	

}
