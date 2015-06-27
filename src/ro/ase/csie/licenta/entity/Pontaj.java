package ro.ase.csie.licenta.entity;

import java.util.Date;

public class Pontaj {
	private long id_pontaj;
	private long id_angajat;
	private Date data_io;
	
	public Pontaj(long id_pontaj, long id_angajat, Date data_io){
		this.id_pontaj=id_pontaj;
		this.id_angajat=id_angajat;
		this.data_io=data_io;
	}
	
	public long getId_pontaj() {
		return id_pontaj;
	}
	public void setId_pontaj(long id_pontaj) {
		this.id_pontaj = id_pontaj;
	}
	public long getId_angajat() {
		return id_angajat;
	}
	public void setId_angajat(long id_angajat) {
		this.id_angajat = id_angajat;
	}
	public Date getData_io() {
		return data_io;
	}
	public void setData_io(Date data_io) {
		this.data_io = data_io;
	}
}
