package ar.edu.unju.fi.aplicacion.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

public class Beca {
	@Positive(message="Debe ser un valor mayor a 0")
	private int codigo;
	@NotNull(message= "Debe elegir un curso.")
	private Curso curso;
	@FutureOrPresent(message="Debe ser una fecha actual o futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fecha_inicio;
	@Future(message="Debe ser una fecha futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fecha_cierre;
	@NotEmpty(message="Debe agregar un estado.")
	private String estado;
	
	public Beca() {
		
	}
	
	public Beca(int codigo, Curso curso, LocalDate fecha_inicio, LocalDate fecha_cierre, String estado) {
		super();
		this.codigo = codigo;
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
