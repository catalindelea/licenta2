package ro.ase.csie.licenta.servicii.mqtt;

import ro.ase.csie.licenta.consola.Input;

public class AscultaMQTT implements Input {
	Subscriber subscriberRPi;
	
	private void opreste() {
		subscriberRPi.opreste();
	}

	@Override
	public void executa() {
		subscriberRPi = new Subscriber();
		subscriberRPi.listen();
	}

}
