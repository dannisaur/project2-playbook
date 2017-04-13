package com.revature.kkoders.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Log service for logging.
 * 
 * Provides high-level logging functionality.
 * 
 * @author
 *
 */
@Component
public class LogService {
	
	/**
	 * Logger for persisting logs.
	 * 
	 */
	@Autowired
	private LogDAOImpl logDao;
	
	/**
	 * Default level at which logs are persisted.
	 * 
	 */
	private Log.Level defaultLevel;
	
	private LogService() {
		defaultLevel = Log.Level.debug; //debug level arbitrarily chosen as initial default level.
	}

	/**
	 * Log a message with the given level.
	 * 
	 * @param level
	 * @param message
	 */
	public void log(Log.Level level, String message) {
		logDao.addLog(level, message);
	}

	/**
	 * Convenience method for logging with the default level.
	 * 
	 * @param message
	 */
	public void log(String message) {
		log(defaultLevel, message);
	}

	public Log.Level getDefaultLevel() {
		return defaultLevel;
	}

	public void setDefaultLevel(Log.Level defaultLevel) {
		this.defaultLevel = defaultLevel;
	}

	/**
	 * Logs a message, at the trace level.
	 * 
	 * @param message
	 */
	public void trace(String message) {
		logDao.addLog(Log.Level.trace, message);
	}

	/**
	 * Logs a message, at the debug level.
	 * 
	 * @param message
	 */
	public void debug(String message) {
		logDao.addLog(Log.Level.debug, message);
	}

	/**
	 * Logs a message, at the info level.
	 * 
	 * @param message
	 */
	public void info(String message) {
		logDao.addLog(Log.Level.info, message);
	}

	/**
	 * Logs a message, at the warn level.
	 * 
	 * @param message
	 */
	public void warn(String message) {
		logDao.addLog(Log.Level.warn, message);
	}

	/**
	 * Logs a message, at the error level.
	 * 
	 * @param message
	 */
	public void error(String message) {
		logDao.addLog(Log.Level.error, message);
	}

	/**
	 * Logs a message, at the fatal level.
	 * 
	 * @param message
	 */
	public void fatal(String message) {
		logDao.addLog(Log.Level.fatal, message);
	}

}
