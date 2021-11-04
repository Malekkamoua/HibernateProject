package com.tn.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = maMethodeStatique();
	private static SessionFactory maMethodeStatique() {
		
		Configuration cfg=new Configuration().configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sessionFactory =cfg.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}

}
