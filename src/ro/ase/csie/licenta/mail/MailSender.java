package ro.ase.csie.licenta.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	public static void trimiteMail(String to, String mesaj){ 
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.starttls.enable","true");
	
	final String username = "licenta.mqtt@gmail.com";
	final String parola = "MQTTCoAP";
	final String from = "licenta.mqtt@gmail.com";
	final String subject = "Raport";
	
	//pentru moment, adresele de email ale managerilor nu exista. toate mailurile vor fi trimise pe catalin.delea@gmail.com
	to = "catalin.delea@gmail.com";
	
	Session session = Session.getDefaultInstance(props, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, parola);
		}
	});

	try {
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		msg.setSubject(subject);
		msg.setText(mesaj);
		Transport.send(msg);

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
