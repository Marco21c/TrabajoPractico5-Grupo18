package ar.edu.unju.fi.aplicacion.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="docentes")
public class Docente {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)  
	@Column(name="LEGAJO_DOC")
	private int legajo;
	@Column(name="NOMBRE_DOC")
	@NotEmpty(message="el nombre del docente no puede estar vacio")
	private String nombre;
	@Column(name="APELLIDO_DOC")
	@NotEmpty(message="el apellido del docente no puede estar vacio")
	private String apellido;
	@Column(name="EMAIL_DOC")
	@NotEmpty @Email
	private String email;
	@Column(name="TELEFONO_DOC")
	@PositiveOrZero
	private long telefono;
	@Column(name="ESTADO_DOC")	
	private boolean estado;
	
	
	@OneToMany(mappedBy ="docente")
	private List<Curso> cursos;
	
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
