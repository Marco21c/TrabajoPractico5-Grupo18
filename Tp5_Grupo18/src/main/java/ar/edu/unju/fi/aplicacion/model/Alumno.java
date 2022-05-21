package ar.edu.unju.fi.aplicacion.model;

public class Alumno {
	private double dni;
	private String nombre;
	private String apellido;
	private String email;
	private double telefono;
	
	
	
	public Alumno(double dni, String nombre, String apellido, String email, double telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public double getDni() {
		return dni;
	}
	public void setDni(double dni) {
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
	public double getTelefono() {
		return telefono;
	}
	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	
	
}
