package ro.ase.csie.licenta.servicii.mqtt;

import static ro.ase.csie.licenta.util.ConstantParams.BROKER;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC_A;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC_C;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC_M;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC_R;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import ro.ase.csie.licenta.servicii.db.hibernate.SalveazaMemorieDB;

public class Subscriber implements MqttCallback {
	
	private static Logger logger = Logger.getLogger(Subscriber.class);
	
	MqttClient listener;
	
	public void listen() {
		try {
			listener = new MqttClient(BROKER, "AbonatServer");
			listener.connect();
			listener.setCallback(this);
			listener.subscribe(TOPIC_R);
			listener.subscribe(TOPIC_A);
			listener.subscribe(TOPIC_M);
			listener.subscribe(TOPIC_C);
			System.out.println("Client conectat si asculta pentru " + TOPIC_R+" "+TOPIC_A+" "+TOPIC_M+" "+TOPIC_C);
		} catch (MqttException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void opreste() {
		try {
			listener.disconnect();
			System.out.println("Clientul nu mai asculta");
		} catch (MqttException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	@Override
	public void messageArrived(String topic, MqttMessage mesaj) throws Exception {
			SalveazaMemorieDB.salveaza(mesaj.toString());
	}

	@Override
	public void connectionLost(Throwable e) {
		logger.error(e);
		e.printStackTrace();
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}
}
