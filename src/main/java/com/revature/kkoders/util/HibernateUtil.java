package com.revature.kkoders.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();//new Configuration().configure().buildSessionFactory();//WHAY DO WE HAVE 2 HIBERNATEUTIL AND THIS ONE WAS CALLING CONFIGURE() WITHOUT PASSING HIBERNATE.CFG.XML IDK SHOULD WE DELETE THIS ONE????

    public static Session getSession() {

        return sessionFactory.openSession();

    }
	
}
