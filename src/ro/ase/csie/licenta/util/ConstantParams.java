package ro.ase.csie.licenta.util;

public class ConstantParams {
	//MQTT connection params
    public static final String TOPIC_R 		 = "RFID";
    public static final String TOPIC_A 		 = "ANGAJAT";
    public static final String TOPIC_C 		 = "CORECTIE";
    public static final String TOPIC_M 		 = "MANAGER";
    public static final int QOS              = 2;
    public static final String HOST          = "tcp://192.168.1.100";
    public static final String PORT          = "1883";
    public static final String BROKER        = HOST+":"+PORT;
    public static final String CLIENT_ID     = "RPiClient";

}
