package ro.ase.csie.licenta.servicii.android;

import ro.ase.csie.licenta.consola.Input;

public class SincronizeazaAndroid implements Input {
	String comandaAsteptata = "-y";
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
