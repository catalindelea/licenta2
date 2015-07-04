package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Manager;

public class Services {
	public static ManagerService getManagerService() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		return managerService;
	}
	
	public static AngajatService getAngajatService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AngajatService angajatService = (AngajatService) ctx.getBean("angajatService");
		return angajatService;
	}
	
	public static PontajService getPontajService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PontajService pontajService = (PontajService) ctx.getBean("pontajService");
		return pontajService;
	}
	
	public static CorectieService getCorectieService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CorectieService corectieService = (CorectieService) ctx.getBean("corectieService");
		return corectieService;
	}
	
	
}
