package ro.ase.csie.licenta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



@Entity
@Table(name = "MANAGER")
public class Manager {
	@Id
	@Column(name = "ID_ANGAJAT")
	private Long id_angajat;
	@Column(name = "NUME")
	private String nume;
	@Column(name = "SALARIU")
	private Long salariu;
	@Column(name = "DEPARTAMENT")
	private String departament;
	@Column(name = "EMAIL")
	private String email;
	
	
	public Manager(){
		
	}
	public Manager(String mesaj) {
		String[] componente = mesaj.split("#");
		this.id_angajat=Long.parseLong(componente[1]);
		this.nume=componente[2];
		this.salariu=Long.parseLong(componente[3]);
		this.departament=componente[4];
		this.email=componente[5];
	}

	public Long getId_angajat() {
		return id_angajat;
	}

	public void setId_angajat(Long id_angajat) {
		this.id_angajat = id_angajat;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Long getSalariu() {
		return salariu;
	}

	public void setSalariu(Long salariu) {
		this.salariu = salariu;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
