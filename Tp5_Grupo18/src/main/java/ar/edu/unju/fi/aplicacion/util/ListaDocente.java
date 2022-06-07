package ar.edu.unju.fi.aplicacion.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.aplicacion.model.Curso;
import ar.edu.unju.fi.aplicacion.model.Docente;
@Component
public class ListaDocente {
	private ArrayList<Docente> docentes;

	public ListaDocente(){
		docentes = new ArrayList<Docente>();
		Curso curso1 = new Curso(1,"Ingles","Idiomas",LocalDate.now(),3,"virtual");
		docentes.add(new Docente(01,"Velazquez","Diego","ariel_123ok@hotmail.com",12312345,curso1));
	}
	
	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
}
