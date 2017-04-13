package com.revature.kkoders.logging;

public interface Log {
	
	/**
	 * Log levels modeled after log4j.
	 * 
	 * @author Michael Hobbs
	 *
	 */
	public enum Level {
		all(1), trace(2), debug(3), info(4), warn(5), error(6), fatal(7), off(8);
		
		private int id;
		
		private Level(int id) {
			this.id = id;
		}
		
		public int getId() {
			return this.id;
		}
		
		/**
		 * Returns the Level identified by id.
		 * 
		 * @param id the id of the Level
		 * @return the Level
		 */
		public static Level getLevel(int id)
        {
			Level[] levels = Level.values();
            for(int i = 0; i < levels.length; i++)
            {
                if(levels[i].id  == id) {
                	return levels[i];
                }
            }
            return null;
        }
		
		/**
		 * Returns the Level identified by name.
		 * 
		 * @param level the name of the Level
		 * @return the Level
		 */
		public static Level getLevel(String level) {
			Level[] levels = Level.values();
			for(int i = 0; i < levels.length; i++) {
				if (levels[i].toString().equalsIgnoreCase(level)) {
					return levels[i];
				}
			}
			return null;
		}
	}
	
	public Integer getLogID();
	
	public void setLogID(Integer logId);
	
	//public Integer getLevel();
	
	//public void setLevel(Integer level);
	
	public String getMessage();
	
	public void setMessage(String message);
		
}
