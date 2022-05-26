package ar.edu.unju.fi.aplicacion.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Curso {
	private int codigo;
	private String titulo;
	private String categoria;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fechai;
	@DateTimeFormat(pattern= "hh:mm:ss")
	private int hora;
	private String modalidad;
	
	
	public Curso() {
		
	}
	
	public Curso(int codigo, String titulo, String categoria, LocalDate fechai, int hora, String modalidad) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechai = fechai;
		this.hora = hora;
		this.modalidad = modalidad;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getFechai() {
		return fechai;
	}
	public void setFechai(LocalDate fechai) {
		this.fechai = fechai;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	
}
