package ro.ase.csie.licenta.servicii.mqtt;

import static ro.ase.csie.licenta.util.ConstantParams.BROKER;
import static ro.ase.csie.licenta.util.ConstantParams.TOPIC;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber implements MqttCallback {
	
	MqttClient client;
	
	public void listen() {
		try {
			client = new MqttClient(BROKER, "AbonatServer");
			client.connect();
			client.setCallback(this);
			client.subscribe(TOPIC);
			System.out.println("Client conectat si asculta pentru " + TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public void opreste() {
		try {
			client.disconnect();
			System.out.println("Clientul nu mai asculta");
		} catch (MqttException e) {
		}
	}

	@Override
	public void messageArrived(String topic, MqttMessage mesaj) throws Exception {
		System.out.println(mesaj);
	}

	@Override
	public void connectionLost(Throwable error) {
		error.printStackTrace();
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}
}
