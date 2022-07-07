package ar.edu.unju.fi.aplicacion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name="ESTADO_ALU")
	private boolean estado;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="alumnos_cursos", joinColumns = @JoinColumn(name="alumno_id"),inverseJoinColumns = @JoinColumn(name="cursos_id"))
	private List<Curso> cursos;
	
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
