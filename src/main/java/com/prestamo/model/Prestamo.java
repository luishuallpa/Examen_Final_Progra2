package com.prestamo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Prestamo implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	@Size(min=8, max=8, message="Debe ingresar su DNI")
	private String dni;
	@NotNull(message = "Debe ingresar su nombre.")
	@Size(min = 2, max = 40, message = "Nombre es muy corto o muy largo")
	private String nombre;
	@NotNull(message = "Debe ingresar su apellido.")
	@Size(min = 2, max = 40, message = "Apellido es muy corto o muy largo")
	private String apellido;
	private Boolean planilla;
	@Email
	private String correo;
	@Min(930)
	private double sueldo;
	private double ImpRentaPagar;
	private String dirrccion;
	private String Telefono;
	private String TipoPrestamo;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Boolean getPlanilla() {
		return planilla;
	}

	public void setPlanilla(Boolean planilla) {
		this.planilla = planilla;
	}

	public double getImpRentaPagar() {
		return ImpRentaPagar;
	}

	public void setImpRentaPagar(double ImpRentaPagar) {
		this.ImpRentaPagar = ImpRentaPagar;
	}

	public String getDirrccion() {
		return dirrccion;
	}

	public void setDirrccion(String dirreccion) {
		this.dirrccion = dirreccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getTipoPrestamo() {
		return TipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		TipoPrestamo = tipoPrestamo;
	}
}
