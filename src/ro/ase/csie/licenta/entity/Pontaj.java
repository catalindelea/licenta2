package ro.ase.csie.licenta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "PONTAJ")
public class Pontaj {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PONTAJ")
	private Long id_pontaj;
	@Column(name = "ID_ANGAJAT")
	private Long id_angajat;
	@Column(name = "DATA_IO")
	private Date data_io;
	
	
	public Pontaj(){
		
	}
	public Pontaj(long id_pontaj, Long id_angajat, Date data_io){
		this.id_pontaj=id_pontaj;
		this.id_angajat=id_angajat;
		this.data_io=data_io;
	}
	
	public Pontaj(Long id_angajat, Date data_io) {
		this.id_angajat=id_angajat;
		this.data_io=data_io;
	}

	public long getId_pontaj() {
		return id_pontaj;
	}
	public void setId_pontaj(long id_pontaj) {
		this.id_pontaj = id_pontaj;
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
}
