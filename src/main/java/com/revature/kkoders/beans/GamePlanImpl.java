package com.revature.kkoders.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="GAME_PLAN")
public class GamePlanImpl implements GamePlan {
	
	@Id
	@Column(name="PLAN_ID")
	@SequenceGenerator(name="PLANID_SEQ", sequenceName="PLANID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLANID_SEQ")
	private int planID;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@Column(name="CULMATIVE_HOURS_PERDAY")
	private double hours;
	
	// ----------------------------------------------------------
	
	// MANY GAME PLANS TO ONE USER
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private UserImpl user;
	
	public void setUserForGamePlan(UserImpl newUser){
		user = newUser;
	}
	
	public UserImpl getUserForGamePlan(){
		return this.user;
	}
	
	// END GETTING USER FOR GAME PLAN
	
	// ----------------------------------------------------------
		
	// ONE GAME PLAN TO MANY DAILY SESSIONS
	@OneToMany(mappedBy = "gamePlan")
	private List<DailySessionImpl> dailySessions;
	
	public void setDailySessions(List<DailySessionImpl> newDailySessions){
		this.dailySessions = newDailySessions;
	}
	
	public List<DailySessionImpl> getDailySessions(){
		return dailySessions;
	}
	
	// END GETTING DAILY SESSIONS
	
	// ----------------------------------------------------------	
	
	public void setUser(UserImpl newUser){
		user = newUser;
	}

	public void setPlanID(int planID) {
		// TODO Auto-generated method stub
		this.planID = planID;
	}

	public int getPlanID() {
		// TODO Auto-generated method stub
		return this.planID;
	}

	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	public void setStartDate(String startDate) {
		// TODO Auto-generated method stub
		this.startDate = startDate;
	}

	public String getStartDate() {
		// TODO Auto-generated method stub
		return this.startDate;
	}

	public void setEndDate(String endDate) {
		// TODO Auto-generated method stub
		this.endDate = endDate;
	}

	public String getEndDate() {
		// TODO Auto-generated method stub
		return this.endDate;
	}

	public void setHoursPerDay(double hours) {
		// TODO Auto-generated method stub
		this.hours = hours;
	}

	public double getHoursPerDay() {
		// TODO Auto-generated method stub
		return this.hours;
	}

	// CONSTRUCTOR WITH FIELDS
	public GamePlanImpl(int planID, String title, String startDate, String endDate, double hours, UserImpl user,
			List<DailySessionImpl> dailySessions) {
		super();
		this.planID = planID;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hours = hours;
		this.user = user;
		this.dailySessions = dailySessions;
	}
	
	// NO ARGS CONSTRUCTOR
	public GamePlanImpl(){}

	@Override
	public String toString() {
		return "GamePlanImpl [planID=" + planID + ", title=" + title + ", startDate=" + startDate + ", endDate="
				+ endDate + ", hours=" + hours + ", user=" + user + ", dailySessions=" + dailySessions + "]";
	}
	
}
