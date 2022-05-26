package ar.edu.unju.fi.aplicacion.util;

import java.util.ArrayList;

import ar.edu.unju.fi.aplicacion.model.Docente;

public class ListaDocente {
	private ArrayList<Docente> docentes;

	public ListaDocente(){
		docentes = new ArrayList<Docente>();
		docentes.add(new Docente(01,"Velazquez","Diego","ariel_123ok@hotmail.com",123));
	}
	
	public ArrayList<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
}
