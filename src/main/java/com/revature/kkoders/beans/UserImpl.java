package com.revature.kkoders.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) 
@Transactional
@Entity
@Scope(value="prototype")
@Table(name="USERS")
public class UserImpl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2859080913261480623L;

	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="USERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERID_SEQ")
	private int userID;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String pw;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PICTURE")
	private String picURL;
	
	@Column(name="DESCRIPTION")
	private String desc;
	
	@Column(name="STEAM_ID")
	private String steamId;

	@OneToMany(fetch=FetchType.EAGER, mappedBy ="pk.user")
	private Set<UserGame> gameLibrary;
	
	
	public Set<UserGame> getGameLib()
	{	
		return gameLibrary;
	}
	
	public final void setGameLibrary(Set<UserGame> gameLibrary)
	{
		this.gameLibrary = gameLibrary;
	}
	
	
	// END GETTING GAMES
	
	// ----------------------------------------------------------

	// THIS IS FOR SETTING AND GETTING GAMEPLANS
	// ONE USER TO MANY GAME PLANS
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "user")
	private Set<GamePlanImpl> gamePlans;
	
	public void setGamePlans(Set<GamePlanImpl> newGamePlans){
		this.gamePlans = newGamePlans;
	}
	
	public Set<GamePlanImpl> getGamePlans(){
		return gamePlans;
	}
	
	// END SETTING AND GETTING GAMEPLANS
	
	// ----------------------------------------------------------
	
	public void setUserID(int userID) {
		// TODO Auto-generated method stub
		this.userID = userID;
	}

	public int getUserID() {
		// TODO Auto-generated method stub
		return this.userID;
	}

	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public void setPw(String pw) {
		// TODO Auto-generated method stub
		this.pw = pw;
	}

	public String getPw() {
		// TODO Auto-generated method stub
		return this.pw;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	public void setPicture(String picURL) {
		// TODO Auto-generated method stub
		this.picURL = picURL;
	}

	public String getPicture() {
		// TODO Auto-generated method stub
		return this.picURL;
	}

	public void setDesc(String desc) {
		// TODO Auto-generated method stub
		this.desc = desc;
	}

	public String getDesc() {
		// TODO Auto-generated method stub
		return this.desc;
	}
	
	public String getSteamId() {
		return steamId;
	}

	public void setSteamId(String steamId) {
		this.steamId = steamId;
	}


	
	// CONSTRUCTOR WITH FIELDS
	public UserImpl(int userID, String firstName, String lastName, String userName, String pw, String email,
			String picURL, String desc, String steamId, Set<UserGame> gameLibrary, Set<GamePlanImpl> gamePlans) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.pw = pw;
		this.email = email;
		this.picURL = picURL;
		this.desc = desc;
		this.steamId = steamId;
		this.gameLibrary = gameLibrary;
		this.gamePlans = gamePlans;
	}
	// NO ARGS CONSTRUCTOR
	public UserImpl(){}

	
	
	// OVERRIDE TOSTRING , gamePlans=" + gamePlans +
	@Override
	public String toString() {
		return "UserImpl [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", pw=" + pw + ", email=" + email + ", picURL=" + picURL + ", desc=" + desc
				+ ", GameLibrary=" + gameLibrary + "]";
	}
	
	
}
