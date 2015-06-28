package ro.ase.csie.licenta.servicii.db.hibernate;

import java.text.ParseException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.consola.Input;
import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Corectie;
import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.entity.Pontaj;

public class SalveazaMemorieDB implements Input {
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	
	public static void salveazaPontaj(Pontaj pontaj) {
		PontajService pontajService = (PontajService) ctx.getBean("pontajService");
		pontajService.insert(pontaj);
	}

	public static void salveazaAngajat(Angajat angajat) {
		AngajatService angajatService = (AngajatService) ctx.getBean("angajatService");
		angajatService.insert(angajat);
	}

	public static void salveazaManager(Manager manager) {
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		managerService.insert(manager);
	}

	public static void salveazaCorectie(Corectie corectie) {
		CorectieService corectieService = (CorectieService) ctx.getBean("corectieService");
		corectieService.insert(corectie);
	}

	public static void salveaza(String s) throws ParseException {
		if (s.startsWith("R")) {
			salveazaPontaj(new Pontaj(Long.parseLong(s.split("#")[1]), new Date()));
		} else if (s.startsWith("A")) {
			salveazaAngajat(new Angajat(s));
		} else if (s.startsWith("M")) {
			salveazaManager(new Manager(s));
		} else if (s.startsWith("C")) {
			salveazaCorectie(new Corectie(s));
		}
	}

	@Override
	public void executa() {
		// TODO Auto-generated method stub

	}

}
