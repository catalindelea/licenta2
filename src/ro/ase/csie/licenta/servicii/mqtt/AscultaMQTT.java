package ro.ase.csie.licenta.servicii.mqtt;

import ro.ase.csie.licenta.consola.Input;

public class AscultaMQTT implements Input {
	String comandaAsteptata = "asculta";
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
		Subscriber subscriber = new Subscriber();
		subscriber.listen();
	}

}
