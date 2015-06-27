package ro.ase.csie.licenta.servicii.mqtt;

import ro.ase.csie.licenta.consola.Input;

public class AscultaMQTT implements Input {
	String comandaAsteptata = "-l";
	Subscriber subscriber;
	
	@Override
	public boolean accepta(String comandaData) {
		if (comandaData.equalsIgnoreCase(comandaAsteptata)) {
			executa();
			return true; 
			}
		else return false;
	}

	private void opreste() {
		subscriber.opreste();
	}

	@Override
	public void executa() {
		subscriber = new Subscriber();
		subscriber.listen();
	}

}
