package ro.ase.csie.licenta.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.log4j.Logger;

import ro.ase.csie.licenta.consola.ConsolaChain;
import ro.ase.csie.licenta.entity.Pontaj;
import ro.ase.csie.licenta.servicii.db.hibernate.PontajDAO;

public class Main {

	
	public static void main(String[] args) {
//		try {
//            BufferedReader cons = new BufferedReader(new InputStreamReader(System.in));
//            while (true) {
//                System.out.print("Input:");
//                String input = cons.readLine();
//                ConsolaChain.process(input);
//            }
//        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		Pontaj pontaj = new Pontaj(2L, 12341234L, new Date());
		PontajDAO dao = new PontajDAO();
		dao.insert(pontaj);
	}

}
