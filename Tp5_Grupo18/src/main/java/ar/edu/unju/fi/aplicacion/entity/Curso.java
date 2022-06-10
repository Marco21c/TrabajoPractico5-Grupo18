package ar.edu.unju.fi.aplicacion.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)  
	@Column(name="ID_CURSO")
	private long codigo;
	@Column(name ="TITULO_CUR")
	@NotEmpty(message= "El titulo no tiene que estar vacio.")
	private String titulo;
	@Column(name="CATEG_CUR")
	@NotEmpty(message= "La Categoria no tiene que estar vacia.")
	private String categoria;
	@Column(name= "FECHAI_CUR")
	@FutureOrPresent(message="Debe ser una fecha actual o futura.")
	@DateTimeFormat(pattern= "yyyy-MM-dd") @NotNull
	private LocalDate fechai;
	@Column(name= "HORA_CUR")
	@Min(value=1, message="La hora debe ser mayor a 0.") 
	private int hora;
	@Column(name= "MODALID_CUR")
	@NotEmpty(message="La modalidad no tiene que estar vacia.")
	private String modalidad;
	
	@OneToMany(mappedBy = "curso" , cascade = CascadeType.ALL)
	private List<Beca> beca = new ArrayList<>();
	
	public Curso() {
		
	}
	
	public Curso(long codigo, String titulo, String categoria, LocalDate fechai, int hora, String modalidad) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechai = fechai;
		this.hora = hora;
		this.modalidad = modalidad;
	}
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
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

	public List<Beca> getBeca() {
		return beca;
	}

	public void setBeca(List<Beca> beca) {
		this.beca = beca;
	}
	
	
}
