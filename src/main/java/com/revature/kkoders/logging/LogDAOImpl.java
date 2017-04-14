package com.revature.kkoders.logging;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.kkoders.hibernateUtil.HibernateUtil;
import com.revature.kkoders.logging.Log.Level;

/**
 * Logger for persisting logs. 
 * 
 * @author
 *
 */
@Component
public class LogDAOImpl implements LogDAO {
	
	static final Logger l = Logger.getRootLogger();
	/**
	 * Log to be persisted.
	 * 
	 */
	@Autowired
	private LogImpl log;
	
	@Autowired
	private LogLevelDAOImpl logLevelDao;

	@Override
	public void addLog(Level level, String message) {
		Session session = HibernateUtil.getSession();
		
		log.setLevel(logLevelDao.getLogLevel(level));
		log.setMessage(message);
		
		Transaction transaction = session.beginTransaction();
		session.save(log);
		transaction.commit();
		
		session.close();
	}

	@Override
	public List<Log> getLogs() {
		Session session = HibernateUtil.getSession();
		
		Query selectQuery = session.createQuery("FROM logImpl");
		List<Log> logs = selectQuery.list();
		
		session.close();
		
		return logs;
	}

	@Override
	public List<Log> getLogs(Level level) {
		Session session = HibernateUtil.getSession();
		
		Criteria criteria = session.createCriteria(LogImpl.class);
		criteria.add(Restrictions.eq("level", level.getId()));
		
		session.close();
		
		return null;
	}
	
}
