package ro.ase.csie.licenta.servicii;

import ro.ase.csie.licenta.consola.Input;
import ro.ase.csie.licenta.servicii.mqtt.Subscriber;

public class PilotAutomat implements Input {
	String comandaAsteptata="-a";
	
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
