package ro.ase.csie.licenta.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import ro.ase.csie.licenta.consola.ConsolaChain;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		try {
            BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Input:");
                String input = cons.readLine();
                ConsolaChain.process(input);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
