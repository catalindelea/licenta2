package ro.ase.csie.licenta.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.QueryHint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.raport.RaportAngajat;
import ro.ase.csie.licenta.util.UtilZile;

public class MainRaportLunar {

	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		AngajatService angajatService = (AngajatService) ctx.getBean("angajatService");
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		ArrayList<Manager> manageri = new ArrayList<Manager>();
//		ManagerService ManagerService = (ManagerService) ctx.getBean("managerService");
//		manageri = (ArrayList<Manager>) ManagerService.selectAll();
//		HashMap<String,Manager> mapManageri = new HashMap<String, Manager>();
//		for (Manager m: manageri) {
////			mapManageri.put(m.getNume(), m);
////			System.out.println(m.toString());
//		}
//		
//		Iterator it = mapManageri.entrySet().iterator();
//	    while (it.hasNext()) {
//	        Map.Entry pair = (Map.Entry)it.next();
//	        System.out.println(pair.getKey() + " = " + pair.getValue());
////	        it.remove(); // avoids a ConcurrentModificationException
//	    }
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		ArrayList<Pontaj> pontaje = new ArrayList<Pontaj>();
//		PontajService pontajService = (PontajService) ctx.getBean("pontajService");
//		pontaje = (ArrayList<Pontaj>) pontajService.selectOnDateForAngajat(UtilZile.getIeri(), 12345678);
//		System.out.println(pontaje.size());
//		System.out.println(RaportAngajat.calculeazaIeriMilis(pontaje));
//		System.out.println(UtilZile.fromMilisToFloatHm(RaportAngajat.calculeazaIeriMilis(pontaje)));
//		for (Pontaj p :pontaje){
//			System.out.println(p.toString());
//		}
		
		RaportAngajat.trimiteRaportLunar(RaportAngajat.verificaLunaTrecutaAngajati());
	}
}
