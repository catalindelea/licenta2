package ro.ase.csie.licenta.temporizare;

import java.util.ArrayList;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.servicii.db.hibernate.ManagerService;

public class TemporizareZilnica extends TimerTask{

	@Override
	public void run() {
		trimiteRaportZilnic();
	}

	private void trimiteRaportZilnic() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ArrayList<Manager> manageri = new ArrayList<Manager>();
		ManagerService ManagerService = (ManagerService) ctx.getBean("managerService");
		manageri = (ArrayList<Manager>) ManagerService.selectAll();
		for (Manager m: manageri) {
			System.out.println(m.toString());
		}
	}

}
