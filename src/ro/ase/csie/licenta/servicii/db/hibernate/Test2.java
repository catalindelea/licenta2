package ro.ase.csie.licenta.servicii.db.hibernate;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ase.csie.licenta.entity.Pontaj;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		PontajService pontajService = (PontajService) ctx.getBean("pontajService");

		Pontaj p = new Pontaj(1L, 12341234L, new Date());

		pontajService.insert(p);

		System.out.println("User inserted!");
	}
}
