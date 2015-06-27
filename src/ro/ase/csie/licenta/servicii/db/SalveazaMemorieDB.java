package ro.ase.csie.licenta.servicii.db;

import ro.ase.csie.licenta.consola.Input;

public class SalveazaMemorieDB implements Input {
	String comandaAsteptata = "salveaza";
	@Override
	public boolean accepta(String comandaData) {
		if (comandaData.equalsIgnoreCase(comandaAsteptata)) {
			executa();
			return true;
		}
		else return false;
	}

	@Override
	public void executa() {
		// TODO Auto-generated method stub

	}

}
