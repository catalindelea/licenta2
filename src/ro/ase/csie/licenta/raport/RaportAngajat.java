package ro.ase.csie.licenta.raport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.servicii.db.hibernate.AngajatService;
import ro.ase.csie.licenta.servicii.db.hibernate.Services;

public class RaportAngajat {
	
	public static long calculeazaIeriMilis(List<Pontaj> lista){
		long rezultat = 0;
		if (lista.size()%2==1) return 0;
		for (int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).toString());
			if (i%2==1) {
				Pontaj iesire = (Pontaj) lista.get(i);
				Pontaj intrare = (Pontaj) lista.get(i-1);
				Date dataIntrare = intrare.getData_io();
				Date dataIesire = iesire.getData_io();
				rezultat += dataIesire.getTime() - dataIntrare.getTime();
			}
		}
		return rezultat;
	}
	
	public static Set<Long> getAngajatiIds(){
		Set<Long> ids = null;
		AngajatService angajatService = Services.getAngajatService();
		ArrayList<Angajat> angajati = new ArrayList<Angajat>();
		angajati = (ArrayList<Angajat>) angajatService.selectAll();
		for (Angajat a : angajati) {
			ids.add(a.getId_angajat());
		}
		return ids;
	}
	
	
}
