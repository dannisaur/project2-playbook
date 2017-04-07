package com.revature.kkoders.beans;

import org.springframework.stereotype.Component;

@Component
public interface GameLibrary {
	
	public void setGameLibID(int gameLibID);
	public int getGameLibID();
	
	public void setGameTitle(String gameTitle);
	public String getGameTitle();
	
	public void setSteamGameID(int steamGameID);
	public int getSteamGameID();
	
	public void setIgdbID(int igdbID);
	public int getIgdbID();
	
	public void setReleaseDate(String releaseDate);
	public String getReleaseDate();
	
	public void setPlatform(String platform);
	public String getPlatform();

}
