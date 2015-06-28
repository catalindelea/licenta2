package ro.ase.csie.licenta.servicii;

import ro.ase.csie.licenta.consola.Input;
import ro.ase.csie.licenta.servicii.mqtt.Subscriber;

public class PilotAutomat implements Input {
	

	@Override
	public void executa() {
		Subscriber subscriberRPi = new Subscriber();
		subscriberRPi.listen();
	}

}
