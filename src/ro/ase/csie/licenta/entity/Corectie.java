package ro.ase.csie.licenta.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;



@Entity
@Table(name = "CORECTIE")
public class Corectie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CORECTIE")
	private Long id_corectie;
	@Column(name = "ID_ANGAJAT")
	private Long id_angajat;
	@Column(name = "DATA_IO")
	private Date data_io;
	@Column(name = "STARE")
	private boolean stare;
	@Column(name = "TIP")
	private int tip;

	public Corectie(){
		
	}
	
	public Corectie(String mesaj) throws ParseException {
		String[] componente = mesaj.split("#");
		this.id_angajat=Long.parseLong(componente[1]);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyyHH:mm");
        try {
        	this.data_io = sdf.parse(componente[2]);
        } catch (Exception e){
            e.printStackTrace();
        }
		this.tip=Integer.parseInt(componente[3]);
		this.stare=false;
	}

	public Long getId_corectie() {
		return id_corectie;
	}

	public void setId_corectie(Long id_corectie) {
		this.id_corectie = id_corectie;
	}

	public Long getId_angajat() {
		return id_angajat;
	}

	public void setId_angajat(Long id_angajat) {
		this.id_angajat = id_angajat;
	}

	public Date getData_io() {
		return data_io;
	}

	public void setData_io(Date data_io) {
		this.data_io = data_io;
	}

	public boolean isStare() {
		return stare;
	}

	public void setStare(boolean stare) {
		this.stare = stare;
	}
}
