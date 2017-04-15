package com.revature.kkoders.beans;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
@Entity
@Table(name="GAME")
public class GameImpl implements Game{
	
	@Id
	@Column(name="GAME_ID")
	@SequenceGenerator(name="GAMEID_SEQ", sequenceName="GAMEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GAMEID_SEQ")
	private int gameLibID;
	
	@Column(name="GAME_TITLE")
	private String gameTitle;
	
	@Column(name="STEAM_GAME_ID")
	private int steamGameID;
	
	@Column(name="IGDB_ID")
	private int igdbID;
	
	@Column(name="RELEASE_DATE")
	private String releaseDate;
	
	@Column(name="PLATFORM_NAME")
	private String platform;
	
	@Column(name="PICTURE")
	private String pic;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy ="pk.game")
	private Set<UserGame> owners;

	@ManyToMany (fetch=FetchType.EAGER, mappedBy="games")
	private Set<GamePlanImpl> plans;
	
	public final Set<UserGame> getOwners()
	{
		return owners;
	}

	public final void setOwners(Set<UserGame> owners)
	{
		this.owners = owners;
	}

	public void setGameLibID(int gameLibID) {
		// TODO Auto-generated method stub
		this.gameLibID = gameLibID;
	}

	public int getGameLibID() {
		// TODO Auto-generated method stub
		return this.gameLibID;
	}

	public void setGameTitle(String gameTitle) {
		// TODO Auto-generated method stub
		this.gameTitle = gameTitle;
	}

	public String getGameTitle() {
		// TODO Auto-generated method stub
		return this.gameTitle;
	}

	public void setSteamGameID(int steamGameID) {
		// TODO Auto-generated method stub
		this.steamGameID = steamGameID;
	}

	public int getSteamGameID() {
		// TODO Auto-generated method stub
		return this.steamGameID;
	}

	public void setIgdbID(int igdbID) {
		// TODO Auto-generated method stub
		this.igdbID = igdbID;
	}

	public int getIgdbID() {
		// TODO Auto-generated method stub
		return this.igdbID;
	}

	public void setReleaseDate(String releaseDate) {
		// TODO Auto-generated method stub
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate() {
		// TODO Auto-generated method stub
		return this.releaseDate;
	}

	public void setPlatform(String platform) {
		// TODO Auto-generated method stub
		this.platform = platform;
	}

	public String getPlatform() {
		// TODO Auto-generated method stub
		return this.platform;
	}

	public final String getPic()
	{
		return pic;
	}

	public final void setPic(String pic)
	{
		this.pic = pic;
	}

	public final Set<GamePlanImpl> getPlans()
	{
		return plans;
	}

	public final void setPlans(Set<GamePlanImpl> plans)
	{
		this.plans = plans;
	}

	//	CONSTRUCTOR WITH FIELDS
	public GameImpl(int gameLibID, String gameTitle, int steamGameID, int igdbID, String releaseDate,
			String platform, String pic) {
		super();
		this.gameLibID = gameLibID;
		this.gameTitle = gameTitle;
		this.steamGameID = steamGameID;
		this.igdbID = igdbID;
		this.releaseDate = releaseDate;
		this.platform = platform;
		this.pic = pic;
	}
	
	// NO ARGS CONSTRUCTOR
	public GameImpl(){}

	@Override
	public String toString() {
		return gameTitle;
	}

	public Set<GamePlanImpl> getPlans() {
		return plans;
	}

	public void setPlans(Set<GamePlanImpl> plans) {
		this.plans = plans;
	}

}
