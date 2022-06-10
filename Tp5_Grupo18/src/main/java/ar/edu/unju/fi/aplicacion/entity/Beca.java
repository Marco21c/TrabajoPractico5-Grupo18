package ar.edu.unju.fi.aplicacion.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "becas")
public class Beca {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="CODIGO_BEC")
	private int codigo;
	@Column(name= "FECHA_INIC_BEC")
	@FutureOrPresent(message="Debe ser una fecha actual o futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fecha_inicio;
	@Column(name= "FECHA_FIN_BEC")
	@Future(message="Debe ser una fecha futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fecha_cierre;
	@Column(name ="ESTADO_BEC")
	@NotEmpty(message="Debe agregar un estado.")
	private String estado;
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "ID_CURSO")
	@NotNull(message= "Debe elegir un curso.")
	private Curso curso;
	
	public Beca() {
		
	}
	
	public Beca(Curso curso, LocalDate fecha_inicio, LocalDate fecha_cierre, String estado) {
		super();
		this.curso = curso;
		this.fecha_inicio = fecha_inicio;
		this.fecha_cierre = fecha_cierre;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(LocalDate fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
