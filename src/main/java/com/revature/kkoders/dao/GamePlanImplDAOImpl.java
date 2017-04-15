package com.revature.kkoders.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.DailySessionImpl;
import com.revature.kkoders.beans.GameImpl;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.beans.GameImpl;
import com.revature.kkoders.beans.GamePlan;
import com.revature.kkoders.beans.GamePlanImpl;
import com.revature.kkoders.beans.UserImpl;
import com.revature.kkoders.hibernateUtil.HibernateUtil;

@Component
public class GamePlanImplDAOImpl implements GamePlanImplDAO {

	@Autowired
	GamePlanImpl newGamePlan;

  @AutoWired
	SteamApiDAOImpl steamApiDao;
	
	@Autowired
	DailySessionImpl dailySession;
	
	@Override
	public List<GamePlanImpl> getGamePlanById(int user_id) {
		Session session = HibernateUtil.getSession();
		// GamePlanImpl user = (GamePlanImpl) session.get(GamePlanImpl.class,
		// user_id);

		String hql = "FROM GamePlanImpl WHERE user.userID =:user_id";
		Query query = session.createQuery(hql);
		query.setParameter("user_id", user_id);
		List<GamePlanImpl> plan = query.list();
		return plan;
	}

	@Override
	public void setTitleForForm(String plan_name, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET title  =:title where uid =:USER_ID";
		Query query = session.createQuery(hql);

		Transaction t = session.beginTransaction();

		query.setParameter("title", plan_name);
		query.setParameter("uid", un);
		query.executeUpdate();

		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void setStartDate(String sd, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET startDate =:startdate where uid =:USER_ID";
		Query query = session.createQuery(hql);

		Transaction t = session.beginTransaction();

		query.setParameter("startdate", sd);
		query.setParameter("uid", un);
		query.executeUpdate();

		session.flush();
		t.commit();
		session.close();
	}

	@Override
	public void setEndDate(String ed, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =:endDate where uid =:USER_ID";
		Query query = session.createQuery(hql);

		Transaction t = session.beginTransaction();

		query.setParameter("endDate", ed);
		query.setParameter("uid", un);
		query.executeUpdate();

		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void ChangeEndDate(String c_ed, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET endDate =:endDate where uid =:USER_ID";
		Query query = session.createQuery(hql);

		Transaction t = session.beginTransaction();

		query.setParameter("endDate", c_ed);
		query.setParameter("uid", un);
		query.executeUpdate();

		session.flush();
		t.commit();
		session.close();

	}

	@Override
	public void setHoursByUser(double uh, int un) {
		Session session = HibernateUtil.getSession();
		String hql = "UPDATE GamePlanImpl SET hours =:hours where uid =:USER_ID";
		Query query = session.createQuery(hql);

		Transaction t = session.beginTransaction();

		query.setParameter("hours", uh);
		query.setParameter("uid", un);
		query.executeUpdate();
		session.flush();
		t.commit();
		session.close();

	}

	@Override

	public void pullDailySessions() {
		Session session = HibernateUtil.getSession();
		
		//users = getUsers();
		//foreach (gameplan of each user in users)
		//	foreach (game in each gameplan)
		//		SteamApi.getPlaytimeTotal()
		//		compute dailyPlaytimeDifferential (today's playtimetotal - initial playtimetotal)
		//		persist session with dailyplaytimedifferential, this gameplan of this user.
		
		System.out.println("GETTING GAMEPLANS");
		Criteria gamePlansCr = session.createCriteria(GamePlanImpl.class);
		List<GamePlanImpl> gamePlans = gamePlansCr.list();
		System.out.println("GOT GAMEPLANS");
		
		for (GamePlanImpl gamePlan : gamePlans) {
			System.out.println("GAMEPLAN: " + gamePlan.getTitle());
			
			System.out.println("GETTING GAMES IN PLAN");
			Set<GameImpl> gamesInPlanSet = gamePlan.getGames();
			List<GameImpl> gamesInPlan = new ArrayList<>(gamesInPlanSet);
			System.out.println("GOT GAMES IN PLAN");
			
			System.out.println("GETTING USER IN PLAN");
			UserImpl userOfGamePlan = gamePlan.getUserForGamePlan();
			System.out.println("GOT USER IN PLAN");
			
			List<Integer> playtimesToday = null;
			System.out.println("GETTING PLAYTIMES OF GAMES IN PLAN");
			if (userOfGamePlan != null && gamesInPlan != null && !gamesInPlan.isEmpty()) {
				playtimesToday = steamApiDao.getPlaytimes(userOfGamePlan, gamesInPlan);
			}
			else {
				System.out.println("NO USER, OR NO GAMES IN PLAN");
			}
			System.out.println("GOT PLAYTIMES OF GAMES IN PLAN");
			
			System.out.println("USER: " + userOfGamePlan.getUserName());
			for (int i = 0; i < gamesInPlan.size(); i++) {
				int hours = playtimesToday.get(i) / 60;
				
				System.out.println("GAME: " + gamesInPlan.get(i).getGameTitle() + ". PLAYTIME (in hours): " + hours);
				
				// commit play session
				Transaction transaction = session.beginTransaction();
				
				dailySession.setHours(hours);
				dailySession.setGamePlanForDailySession(gamePlan);
				
				session.save(dailySession);
				
				transaction.commit();
			}
			
			// TODO: get difference in times between played today and last session  

		}
		
		session.close();
  }

	public void CreateGamePlan(String planName, String startDate, String endDate, double hours, Set<GameImpl> selectedGames, UserImpl user) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		newGamePlan.setTitle(planName);
		newGamePlan.setStartDate(startDate);
		newGamePlan.setEndDate(endDate);
		newGamePlan.setHoursPerDay(hours);
		newGamePlan.setGamesInPlan(selectedGames);
		newGamePlan.setUserForGamePlan(user);
		
		session.save(newGamePlan);
		session.getTransaction();
		System.out.println("saving info");
		t.commit();
		session.close();
	}

}
