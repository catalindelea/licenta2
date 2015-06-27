package ro.ase.csie.licenta.servicii.db.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
	private SessionFactory sessionFactory = null;
	private static HibernateUtil singleton = new HibernateUtil();
	private Configuration config;
	
	private HibernateUtil(){
	    try {
    	    config = new Configuration();
    	    config.configure("hibernate.cfg.xml");
    	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
	}
	
	public static SessionFactory getSessionFactory(){
		return singleton.sessionFactory;		
	}
}
