package ar.edu.unju.fi.aplicacion.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.stereotype.Component;


public class Docente {
	@PositiveOrZero
	private int legajo;
	@NotEmpty(message="el nombre del docente no puede estar vacio")
	private String nombre;
	@NotEmpty(message="el apellido del docente no puede estar vacio")
	private String apellido;
	@NotEmpty @Email
	private String email;
	@NotEmpty(message="El telefono no puede ser vacio")
	private int telefono;
	
	public Docente() {
		
	}
	
	public Docente(int legajo, String nombre, String apellido, String email, int telefono) {
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
