package ro.ase.csie.licenta.entity;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class Centralizare {
	private static Logger logger = Logger.getLogger(Centralizare.class);
	private static final Centralizare centralizare=new Centralizare();
	
	private HashMap<Long, Date> pontari;
	
	
	private Centralizare(){
		this.pontari = new HashMap<Long,Date>();
	}
	
	public static Centralizare getInstance(){
		return centralizare;
	}
	public void adaugaPontare(Long id_angajat) {
			this.pontari.put(id_angajat, new Date());
	}
}
