package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Angajat;
import ro.ase.csie.licenta.entity.Pontaj;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AngajatService angajatService = (AngajatService) ctx.getBean("angajatService");
		
		Angajat a = new Angajat("A#85235282#hahs#123456789#12345778#twgsgsgs");
		
//		Pontaj p = new Pontaj(1L, 12341234L, new Date());

		angajatService.insert(a);

		System.out.println("User inserted!");
	}
}
