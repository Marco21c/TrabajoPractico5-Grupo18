package ar.edu.unju.fi.aplicacion.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.aplicacion.model.Beca;
import ar.edu.unju.fi.aplicacion.model.Curso;
@Component
public class ListaBecas {
	ArrayList<Beca> becas;
	
	public ListaBecas(){
		becas = new ArrayList<Beca>();
		Curso curso1 = new Curso(1,"Ingles","Idiomas",LocalDate.now(),3,"virtual");
		becas.add(new Beca(1,curso1,LocalDate.of(2023, 10, 10),LocalDate.of(2023, 12, 10),"aprobado"));
	}

	public ArrayList<Beca> getBecas() {
		return becas;
	}

	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}
	
	
}