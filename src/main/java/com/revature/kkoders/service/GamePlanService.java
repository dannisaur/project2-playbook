package com.revature.kkoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.dao.GamePlanImplDAOImpl;
import com.revature.kkoders.beans.UserImpl;

@Component
public class GamePlanService {

	@Autowired
	GamePlanImplDAOImpl gamePlanDAO;

	// The following functions will set/change the game plan for the user
	public boolean GameTitle(String name, int id) {
		boolean complete = false;

		if (name.isEmpty() && (name instanceof String == false) & id < 0) {
			System.out.println("You need to pass in ");
			return complete;
		}

		else {
			gamePlanDAO.setTitleForForm(name, id);
			complete = true;
		}
		return complete;

	}

	// id should be the username passed in and name is the date as a string
	// format
	public boolean StartDate(String name, int id) {
		boolean complete;

		if (name.isEmpty() & (name instanceof String == false) & id < 0) {
			System.out.println("You need to pass in a string and the id can not be negative");
			complete = false;
		} else {
			gamePlanDAO.setEndDate(name, id);
			complete = true;
		}

		return complete;
	}

	// id is the user id in the game plan table which should be retrived by the
	// user
	//
	public boolean EndDate(String name, int id) {
		boolean complete;
		if (name.isEmpty() & (name instanceof String == false) & id < 0) {
			System.out.println("You need to pass in a string and the id can not be negative");
			complete = false;
		}

		else {
			gamePlanDAO.ChangeEndDate(name, id);
			complete = true;
		}

		return complete;
	}

	public boolean HoursSet(double h, int id) {
		boolean complete;
		if (h < 0.0 & id < 0) {
			System.out.println("These numbers should not be negtive!!");
			complete = false;
		} else {
			gamePlanDAO.setHoursByUser(h, id);
			complete = true;
		}

		return complete;
	}

	public void GamePlanSet(GamePlanImpl gm, UserImpl user) {
		gamePlanDAO.CreateGamePlan(gm.getTitle(), gm.getStartDate(), gm.getEndDate(), gm.getHoursPerDay(),
				gm.getGamesInPlan(), user);
		
		System.out.println("Game Plan added.");
	}

	public List<GamePlanImpl> GetPlansWithId(int id) {

		return gamePlanDAO.getGamePlanById(id);
	}

	/**
	 * Pulls the daily session for every user and every game plan.
	 * 
	 */
	//@Scheduled(cron="59 59 23 * * *") //pulling daily sessions is scheduled for 11:59:59 PM every day.
	@Scheduled(cron="0 */1 * * * *") //CURRENT TEST: run every 1 minute
	public void pullDailySessions() {
		System.out.println("RUNNING SCHEDULED TASK TO PULL DAILY SESSIONS:");//test statement.

		gamePlanDAO.pullDailySessions();
	}
	// */
}
