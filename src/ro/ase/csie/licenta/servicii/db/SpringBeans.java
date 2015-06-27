package ro.ase.csie.licenta.servicii.db;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.servicii.db.hibernate.PontajService;

public class SpringBeans {
	private static Logger logger = Logger.getLogger(SpringBeans.class);
	private static SpringBeans springBeans = new SpringBeans();
	private static ApplicationContext ctx;
	
	private SpringBeans(){
		this.ctx = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	public static SpringBeans getInstance(){
		if (springBeans==null) return new SpringBeans();
		else return springBeans;
	}
	
	public PontajService getPontajService(){
		return (PontajService) ctx.getBean("pontajService");
	}
}
