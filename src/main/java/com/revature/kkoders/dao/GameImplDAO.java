package com.revature.kkoders.dao;

import java.util.Set;

import com.revature.kkoders.beans.GameImpl;

public interface GameImplDAO {
	
	public GameImpl getLibraryById(int gl_id);
	public void CreateLibrary(String gm_t, int st_id, int igDB_idm, 
			String Rdate, String Platform);
	public Set<String> getAllPlatforms();
	public Set<Integer> getSteamIds();
	public Set<Integer> getIgdbIds();
	public Set<String> getAllGameTitles();
	public void RemoveGameTtle(String gm);
	public void RemoveReleaseDateByGameTitle(String gm);
	

}
