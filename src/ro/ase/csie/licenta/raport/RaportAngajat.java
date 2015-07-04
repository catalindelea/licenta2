package ro.ase.csie.licenta.raport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.AngajatCuOre;
import ro.ase.csie.licenta.entity.Manager;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.mail.MailSender;
import ro.ase.csie.licenta.servicii.db.hibernate.AngajatService;
import ro.ase.csie.licenta.servicii.db.hibernate.PontajService;
import ro.ase.csie.licenta.servicii.db.hibernate.Services;
import ro.ase.csie.licenta.util.UtilZile;

public class RaportAngajat {

	public static long calculeazaIeriMilis(List<Pontaj> lista) {
		long rezultat = 0;
		if (lista.size() % 2 == 1)
			return 0;
		for (int i = 0; i < lista.size(); i++) {
			if (i % 2 == 1) {
				Pontaj iesire = (Pontaj) lista.get(i);
				Pontaj intrare = (Pontaj) lista.get(i - 1);
				Date dataIntrare = intrare.getData_io();
				Date dataIesire = iesire.getData_io();
				rezultat += dataIesire.getTime() - dataIntrare.getTime();
			}
		}
		return rezultat;
	}

	public static Set<Long> getAngajatiIds() {
		Set<Long> ids = new HashSet<Long>();
		AngajatService angajatService = Services.getAngajatService();
		ArrayList<Angajat> angajati = new ArrayList<Angajat>();
		angajati = (ArrayList<Angajat>) angajatService.selectAll();
		for (Angajat a : angajati) {
			ids.add(a.getId_angajat());
		}
		return ids;
	}

	public static void verificaIeriAngajati() {
		Date azi = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(azi);
		PontajService pontajService = Services.getPontajService();
		// if (calendar.get(Calendar.DAY_OF_WEEK)==6 ||
		// calendar.get(Calendar.DAY_OF_WEEK)==0) return;
		Set<Long> idsAngajat = getAngajatiIds();
		for (Long id_angajat : idsAngajat) {
			ArrayList<Pontaj> pontajeIeriAngajat = new ArrayList<Pontaj>();
			pontajeIeriAngajat = (ArrayList<Pontaj>) pontajService.selectOnDateForAngajat(UtilZile.getIeri(), id_angajat);
			float oreLucrateIeri = UtilZile.fromMilisToFloatHm(RaportAngajat.calculeazaIeriMilis(pontajeIeriAngajat));
			if (oreLucrateIeri < 2) {
				MailSender.trimiteMail(Services.getAngajatService().getEmailAddressForManager(id_angajat), genereazaRaport(id_angajat, UtilZile.getIeri(), oreLucrateIeri));
			}
		}
	}

	private static String genereazaRaport(Long id_angajat, Date ieri, float ore) {
		Angajat a = Services.getAngajatService().selectById(id_angajat);
		StringBuilder sb = new StringBuilder();
		sb.append("Atentie. Angajatul cu id-ul ").append(id_angajat).append(", cu numele" + a.getNume()).append(", din departamentul ").append(a.getDepartament())
				.append(" a efectuat in data de " + ieri.toString()).append(" un numar de ").append(ore).append(" ore de lucru").append("\n\n\n").append("Mesaj trimis de catre sistemul de pontaj");
		return sb.toString();
	}

	public static List<AngajatCuOre> verificaLunaTrecutaAngajati() {
		ArrayList<AngajatCuOre> angajatiCuOre = new ArrayList<AngajatCuOre>();
		PontajService pontajService = Services.getPontajService();
		AngajatService angajatService = Services.getAngajatService();
		Set<Long> idsAngajat = getAngajatiIds();
		for (Long id_angajat : idsAngajat) {
			ArrayList<Pontaj> pontajeLunaTrecutaAngajat = new ArrayList<Pontaj>();
			pontajeLunaTrecutaAngajat = (ArrayList<Pontaj>) pontajService.selectOnMonthForAngajat(new Date(), id_angajat);
			float oreLucrateLunaTrecuta = UtilZile.fromMilisToFloatHm(RaportAngajat.calculeazaIeriMilis(pontajeLunaTrecutaAngajat));
			angajatiCuOre.add(new AngajatCuOre(angajatService.selectById(id_angajat), oreLucrateLunaTrecuta));
		}
		return angajatiCuOre;
	}

	//
	public static void trimiteRaportLunar(List<AngajatCuOre> angajatiCuOre) {
		ArrayList<Manager> manageri = (ArrayList<Manager>) Services.getManagerService().selectAll();
		for (Manager m : manageri) {
			StringBuilder sb = new StringBuilder();
			for (AngajatCuOre a : angajatiCuOre) {
				if ((long) a.getAngajat().getId_manager() == (long) m.getId_angajat()) {
					float salariu = (a.getNumarOre() / 160) * a.getAngajat().getSalariu();
					sb.append("Angajatul " + a.getAngajat().getNume() + " cu id-ul " + a.getAngajat().getId_angajat())
							.append(" a lucrat " + a.getNumarOre() + " (de) ore si va fi platit luna asta cu ").append(fmt(salariu)).append(" RON\n");
				}
			}
			if (!sb.toString().trim().equals("")) {
				MailSender.trimiteMail(m.getEmail(), sb.toString());
				System.out.println("Am trimis un raport catre managerul " + m.getNume() + " din departamentul " + m.getDepartament());
			}
		}
	}

	public static String fmt(float f) {
		return String.format("%.2f", f);
	}
}
