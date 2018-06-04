package com.prestamo.clases;

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
}
