package com.prestamo.clases;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Method {
	public double impuestoPagar(double sueldo, boolean planilla) {
		double UIT = 4050;
		double escala1=UIT*5;
		double escala2=UIT*20;
		double escala3=UIT*35;
		double escala4=UIT*45;
		double indiceUIT;
		double escalafija;
		double escalavariable;
		double sueldoTotalBruto;
		if (planilla == true) { 
			sueldoTotalBruto= sueldo * 14;
		}else {
			sueldoTotalBruto= sueldo * 12;
		}
		double UITdesc = UIT *7;
		double rentaNeta = sueldoTotalBruto - UITdesc;
		indiceUIT = rentaNeta/UIT;
		if (indiceUIT>45) {
			
			escalafija=(escala4-escala3)*0.2+(escala3-escala2)*0.17+(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaNeta-escalafija)*0.3;
		}else if(indiceUIT>35){
			
			escalafija=(escala3-escala2)*0.17+(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaNeta-escalafija)*0.2;
		}else if(indiceUIT>20){
			
			escalafija=(escala2-escala1)*0.14+escala1*0.08;
			escalavariable=(rentaNeta-escalafija)*0.17;
		}else if(indiceUIT>5){
			
			escalafija=escala1*0.08;
			escalavariable=(rentaNeta-escalafija)*0.14;
		}else {
			
			escalafija=0;
			escalavariable=(rentaNeta-escalafija)*0.08;
		}
		
		return escalafija+escalavariable;
	}
	
	public void mail(String destinatario, String asunto, String cuerpo) {
		    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
		    String remitente = "proyectoprogra2018@gmail.com";  //Para la dirección nomcuenta@gmail.com

		    Properties props = System.getProperties();
		    props.put("mail.smtp.user","proyectoprogra2018@gmail.com"); 
		    props.put("mail.smtp.host", "smtp.gmail.com"); 
		    props.put("mail.smtp.port", "25"); 
		    props.put("mail.debug", "true"); 
		    props.put("mail.smtp.auth", "true"); 
		    props.put("mail.smtp.starttls.enable","true"); 
		    props.put("mail.smtp.EnableSSL.enable","true");

		    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		    props.setProperty("mail.smtp.socketFactory.fallbac k", "false"); 
		    props.setProperty("mail.smtp.port", "465"); 
		    props.setProperty("mail.smtp.socketFactory.port", "465"); 
		 

		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);

		    try {
		        message.setFrom(new InternetAddress(remitente));
		        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
		        message.setSubject(asunto);
		        message.setText(cuerpo);
		        Transport transport = session.getTransport("smtp");
		        transport.connect("smtp.gmail.com", remitente,"AEIOU12345" );//Clave
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    catch (MessagingException me) {
		        me.printStackTrace();   //Si se produce un error
		    }
	}
}
