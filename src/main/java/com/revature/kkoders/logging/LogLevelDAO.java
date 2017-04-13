package com.revature.kkoders.logging;

import com.revature.kkoders.logging.Log.Level;

public interface LogLevelDAO {
	
	public LogLevelImpl getLogLevel(Level level);

}
