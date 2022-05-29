package ar.edu.unju.fi.aplicacion.model;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

public class Curso {
	@Positive(message="Debe ingresar un numero mayor a 0")  
	private int codigo;
	@NotEmpty(message= "El titulo no tiene que estar vacio.")
	private String titulo;
	@NotEmpty(message= "La Categoria no tiene que estar vacia.")
	private String categoria;
	@FutureOrPresent(message="Debe ser una fecha actual o futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private LocalDate fechai;
	@Min(value=1, message="La hora debe ser mayor a 0.") @Max(value=24, message="La hora debe ser menor a 24.")
	private int hora;
	@NotEmpty(message="La modalidad no tiene que estar vacia.")
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
