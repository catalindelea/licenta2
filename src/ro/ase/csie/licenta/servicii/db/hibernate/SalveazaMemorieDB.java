package ro.ase.csie.licenta.servicii.db.hibernate;

import java.awt.Toolkit;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.consola.Input;
import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Corectie;
import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.entity.Pontaj;

public class SalveazaMemorieDB implements Input {

	static Logger logger = Logger.getLogger(SalveazaMemorieDB.class);


	public static void salveazaPontaj(Pontaj pontaj) {
		PontajService pontajService = Services.getPontajService();
		try {
			pontajService.insert(pontaj);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void salveazaAngajat(Angajat angajat) {
		AngajatService angajatService = Services.getAngajatService();
		try {
			angajatService.insert(angajat);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void salveazaManager(Manager manager) {
		ManagerService managerService = Services.getManagerService();
		try {
			managerService.insert(manager);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void salveazaCorectie(Corectie corectie) {
		CorectieService corectieService = Services.getCorectieService();
		try {
			corectieService.insert(corectie);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void salveaza(String s) throws ParseException {
		try {
			Toolkit.getDefaultToolkit().beep();
			if (s.startsWith("R")) {
				salveazaPontaj(new Pontaj(Long.parseLong(s.split("#")[1]), new Date()));
			} else if (s.startsWith("A")) {
				salveazaAngajat(new Angajat(s));
			} else if (s.startsWith("M")) {
				salveazaManager(new Manager(s));
			} else if (s.startsWith("C")) {
				salveazaCorectie(new Corectie(s));
			} else
				throw new UnsupportedOperationException("Nu se pot insera mesaje cu alt cod de incept decat cele mentionate");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	public void executa() {
		// TODO Auto-generated method stub

	}

}
