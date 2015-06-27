package ro.ase.csie.licenta.servicii.db;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.consola.Input;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.servicii.db.hibernate.PontajService;

public class SalveazaMemorieDB implements Input {
	String comandaAsteptata = "-s";
	
	
		
	@Override
	public boolean accepta(String comandaData) {
		if (comandaData.equalsIgnoreCase(comandaAsteptata)) {
			executa();
			return true;
		}
		else return false;
	}

	public static void salveazaLive(Pontaj pontaj) {
		SpringBeans.getInstance().getPontajService().insert(pontaj);
	}
	
	@Override
	public void executa() {
		// TODO Auto-generated method stub

	}

}
