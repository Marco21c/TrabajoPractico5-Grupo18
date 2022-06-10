package ar.edu.unju.fi.aplicacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="alumnos")
public class Alumno {
	@Id
	@Column(name= "DNI_ALU")
	private long dni;
	@Column(name= "NOMBRE_ALU")
	private String nombre;
	@Column(name="APELLIDO_ALU")
	private String apellido;
	@Column(name="EMAIL_ALU")
	private String email;
	@Column(name="TEL_ALU")
	private long telefono;
	
	public Alumno() {
	}
	
	public Alumno(long dni, String nombre, String apellido, String email, long telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
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
