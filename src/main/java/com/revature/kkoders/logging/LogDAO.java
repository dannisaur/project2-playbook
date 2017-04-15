package com.revature.kkoders.logging;

import java.util.List;

import com.revature.kkoders.logging.Log.Level;

public interface LogDAO {

	/**
	 * Persists the given message with the given level.
	 * 
	 */
	void addLog(Log.Level level, String message);
	
	/**
	 * Retrieves all logs.
	 * 
	 * @return
	 */
	List<Log> getLogs();

	/**
	 * Retrieves all logs of a given level.
	 * 
	 * @param level
	 * @return
	 */
	List<Log> getLogs(Level level);
	
}
