package ro.ase.csie.licenta.servicii.mqtt;

import static ro.ase.csie.licenta.util.ConstantParams.BROKER;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC;

import java.util.Date;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.servicii.db.SalveazaMemorieDB;
import ro.ase.csie.licenta.util.IDValidator;

public class Subscriber implements MqttCallback {
	
	private static Logger logger = Logger.getLogger(Subscriber.class);
	
	MqttClient client;
	
	public void listen() {
		try {
			client = new MqttClient(BROKER, "AbonatServer");
			client.connect();
			client.setCallback(this);
			client.subscribe(TOPIC);
			System.out.println("Client conectat si asculta pentru " + TOPIC);
		} catch (MqttException e) {
			logger.error(e);
		}
	}

	public void opreste() {
		try {
			client.disconnect();
			System.out.println("Clientul nu mai asculta");
		} catch (MqttException e) {
			logger.error(e);
		}
	}

	@Override
	public void messageArrived(String topic, MqttMessage mesaj) throws Exception {
		Long id = IDValidator.parsedValidation(mesaj.toString());
		if (id!=null) {
			Pontaj pontaj = new Pontaj (id, new Date());
			SalveazaMemorieDB.salveazaLive(pontaj);
		}
	}

	@Override
	public void connectionLost(Throwable e) {
		logger.error(e);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}
}
