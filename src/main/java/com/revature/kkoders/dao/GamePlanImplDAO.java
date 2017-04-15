package com.revature.kkoders.dao;

import java.util.List;
import java.util.Set;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GamePlan;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;

public interface GamePlanImplDAO {

	public List<GamePlanImpl> getGamePlanById(int user_id);

	public void setTitleForForm(String plan_name, int un);

	public void setStartDate(String sd, int un);

	public void setEndDate(String ed, int un);

	public void ChangeEndDate(String c_ed, int un);

	public void setHoursByUser(double uh, int un);

	public void CreateGamePlan(String planName, String startDate, String endDate, double hours,
			Set<GameImpl> selectedGames, UserImpl user);

}
