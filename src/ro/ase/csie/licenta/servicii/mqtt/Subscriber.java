package ro.ase.csie.licenta.servicii.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static ro.ase.csie.licenta.util.ConstantParams.*;

public class Subscriber implements MqttCallback {
	public void listen() {
		try {
			MqttClient client= new MqttClient(BROKER, "AbonatServer");
			client.connect();
			client.setCallback(this);
			client.subscribe(TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void messageArrived(String topic, MqttMessage mesaj)throws Exception {
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
