package com.revature.kkoders.logging;

import com.revature.kkoders.logging.Log.Level;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.kkoders.hibernateUtil.HibernateUtil;

@Component
public class LogLevelDAOImpl implements LogLevelDAO {

	public LogLevelImpl getLogLevel(Level level) {
		Session session = HibernateUtil.getSession();
		
		Query query = session.createQuery("FROM LogLevelImpl l WHERE l.levelID = :levelID");
		query.setInteger("levelID", level.getId());
		List<LogLevelImpl> log = query.list();
		
		session.close();
		return log.get(0);
	}

}
