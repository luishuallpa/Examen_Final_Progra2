package com.proyecto.prestamos.model;

public class Cliente {
	String nombres;
	int dni;
	String apellidos;
	double ingresoMensual;
	double gastoMensual;
	String hobby;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getdni() {
		return dni;
	}

	public void setdni(int dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(double ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public double getGastoMensual() {
		return gastoMensual;
	}

	public void setGastoMensual(double gastoMensual) {
		this.gastoMensual = gastoMensual;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
