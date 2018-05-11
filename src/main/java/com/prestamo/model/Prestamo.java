package com.prestamo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Prestamo implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull(message = "Debe ingresar su nombre.")
	@Size(min = 2, max = 40, message = "Nombre es muy corto o muy largo")
	private String nombre;
	@NotNull(message = "Debe ingresar su apellido.")
	@Size(min = 2, max = 40, message = "Apellido es muy corto o muy largo")
	private String apellido;
	@NotNull(message = "Debe ingresar su DNI.")
	@Size(min = 7, max = 8, message = "El DNI es de 8 digitos.")
	private String dni;
	@Min(930)
	private double ingresoMensual;
	@Min(930)
	private double gastoMensual;
	@NotNull(message = "Debe ingresar su hobby.")
	@Size(min = 2, max = 40, message = "No reconoce este hobby. Se más preciso.")
	private String hobby;
	private Integer Resultado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public Integer getResultado() {
		return Resultado;
	}

	public void setResultado(Integer resultado) {
		Resultado = resultado;
	}
}
