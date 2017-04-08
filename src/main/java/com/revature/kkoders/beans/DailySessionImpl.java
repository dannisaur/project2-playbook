package com.revature.kkoders.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="DAILY_SESSION")
public class DailySessionImpl implements DailySession {
	
	@Id
	@Column(name="DAILY_SESSION_ID")
	@SequenceGenerator(name="DAILYSESSIONID_SEQ", sequenceName="DAILYSESSIONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DAILYSESSIONID_SEQ")
	private int dailySessionID;
	
	@Column(name="HOURS")
	private double hours;
	
	// ----------------------------------------------------------
	
	// MANY DAILY SESSIONS TO ONE GAME PLAN
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PLAN_ID")
	private GamePlanImpl gamePlan;
	
	public void setGamePlanForDailySession(GamePlanImpl newGamePlan){
		gamePlan = newGamePlan;
	}
	
	public GamePlanImpl getGamePlanForDailySession(){
		return this.gamePlan;
	}
	
	// END GETTING GAME PLAN FOR DAILY SESSION
	
	// ----------------------------------------------------------

	public void setDailySessionID(int dailySessionID) {
		// TODO Auto-generated method stub
		this.dailySessionID = dailySessionID;
	}

	public int getDailySessionID() {
		// TODO Auto-generated method stub
		return this.dailySessionID;
	}

	public void setHours(double hours) {
		// TODO Auto-generated method stub
		this.hours = hours;
	}

	public double getHours() {
		// TODO Auto-generated method stub
		return this.hours;
	}

	// CONSTRUCTOR WITH FIELDS
	public DailySessionImpl(int dailySessionID, double hours, GamePlanImpl gamePlan) {
		super();
		this.dailySessionID = dailySessionID;
		this.hours = hours;
		this.gamePlan = gamePlan;
	}
	
	// NO ARGS CONSTRUCTOR
	public DailySessionImpl(){}

	@Override
	public String toString() {
		return "DailySessionImpl [dailySessionID=" + dailySessionID + ", hours=" + hours + ", gamePlan=" + gamePlan
				+ "]";
	}

}
