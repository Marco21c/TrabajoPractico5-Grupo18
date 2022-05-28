package ar.edu.unju.fi.aplicacion.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;


public class Docente {
	@Min(value=1, message="el legajo debe ser mayor a 0") @NotEmpty
	private int legajo;
	@NotEmpty(message="el nombre del docente no puede estar vacio")
	private String nombre;
	@NotEmpty(message="el apellido del docente no puede estar vacio")
	private String apellido;
	@NotEmpty @Email
	private String email;
	@PositiveOrZero
	private long telefono;
	
	public Docente() {
		
	}
	
	public Docente(int legajo, String nombre, String apellido, String email, long telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	
}
