package ro.ase.csie.licenta.consola;

import ro.ase.csie.licenta.servicii.android.SincronizeazaAndroid;
import ro.ase.csie.licenta.servicii.db.SalveazaMemorieDB;
import ro.ase.csie.licenta.servicii.mqtt.AscultaMQTT;


public class ConsolaChain {
	
    private static Input[] inputChain = new Input[]{
    	new AscultaMQTT(),
    	new SalveazaMemorieDB(), 
    	new SincronizeazaAndroid(),
    	new ReadWrongInput()};
    
    public static void process(String comandaData){
        for (Input input: inputChain){
            input.accepta(comandaData);
        }
    }
}
