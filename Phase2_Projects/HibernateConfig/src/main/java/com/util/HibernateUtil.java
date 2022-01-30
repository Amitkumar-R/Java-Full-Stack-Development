package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sf;
	
	static {
		try {
			StandardServiceRegistry ssr = 
					new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();
		} catch(Throwable th) {
			throw new ExceptionInInitializerError(th);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
