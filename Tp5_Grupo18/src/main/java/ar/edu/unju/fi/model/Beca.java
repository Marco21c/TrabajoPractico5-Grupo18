package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Beca {
	private int codigo;
	private Curso curso;
	private LocalDate fecha_inicio;
	private LocalDate fecha_cierre;
	private String estado;
	
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
