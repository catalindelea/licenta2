package ro.ase.csie.licenta.entity;

public class AngajatCuOre {
	private Angajat angajat;
	private float numarOre;
	
	public AngajatCuOre(Angajat angajat, float numarOre) {
		this.angajat = angajat;
		this.numarOre = numarOre;
	}
	
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public float getNumarOre() {
		return numarOre;
	}
	public void setNumarOre(float numarOre) {
		this.numarOre = numarOre;
	}
	
}
