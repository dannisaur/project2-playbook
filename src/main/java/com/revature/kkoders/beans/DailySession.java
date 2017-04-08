package com.revature.kkoders.beans;

import org.springframework.stereotype.Component;

@Component
public interface DailySession {
	
	public void setDailySessionID(int dailySessionID);
	public int getDailySessionID();
	
	public void setHours(double hours);
	public double getHours();
	
//	public void setGamePlan(GamePlanImpl gamePlan);
//	public GamePlanImpl getGamePlan();

}
