package ro.ase.csie.licenta.raport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.servicii.db.hibernate.AngajatService;
import ro.ase.csie.licenta.servicii.db.hibernate.PontajService;
import ro.ase.csie.licenta.servicii.db.hibernate.Services;
import ro.ase.csie.licenta.util.UtilZile;

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
	
	
	public static void verificaIeriAngajati(){
		Date azi = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(azi);
        PontajService pontajService = Services.getPontajService();
        if (calendar.get(Calendar.DAY_OF_WEEK)==6 || calendar.get(Calendar.DAY_OF_WEEK)==0) return;
        Set<Long> idsAngajat = getAngajatiIds();
        for (Long id_angajat : idsAngajat){
        	ArrayList<Pontaj> pontajeIeriAngajat = new ArrayList<Pontaj>();
        	pontajeIeriAngajat = (ArrayList<Pontaj>) pontajService.selectOnDateForAngajat(UtilZile.getIeri(), id_angajat);
        	float oreLucrateIeri = UtilZile.fromMilisToFloatHm(RaportAngajat.calculeazaIeriMilis(pontajeIeriAngajat));
//        	if (oreLucrateIeri < 2) 
//        		anuntaManager(id_angajat);
        }
	}
	
	public static HashMap<Float, Angajat> verificaLunaTrecutaAngajati(){
		HashMap<Float, Angajat> oreLunaAngajat = new HashMap<Float, Angajat>();
        PontajService pontajService = Services.getPontajService();
        AngajatService angajatService = Services.getAngajatService();
        Set<Long> idsAngajat = getAngajatiIds();
        for (Long id_angajat : idsAngajat){
        	ArrayList<Pontaj> pontajeLunaTrecutaAngajat = new ArrayList<Pontaj>();
        	pontajeLunaTrecutaAngajat = (ArrayList<Pontaj>) pontajService.selectOnDateForAngajat(new Date(), id_angajat);
        	float oreLucrateLunaTrecuta = UtilZile.fromMilisToFloatHm(RaportAngajat.calculeazaIeriMilis(pontajeLunaTrecutaAngajat));
        	oreLunaAngajat.put(oreLucrateLunaTrecuta, angajatService.selectById(id_angajat));
        }
        return oreLunaAngajat;
	}
}
