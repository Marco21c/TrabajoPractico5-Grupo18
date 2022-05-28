package ar.edu.unju.fi.aplicacion.util;

import java.util.ArrayList;
import ar.edu.unju.fi.aplicacion.model.Beca;

public class ListaBecas {
	ArrayList<Beca> becas;
	
	public ListaBecas(){
		becas = new ArrayList<Beca>();
	}

	public ArrayList<Beca> getBecas() {
		return becas;
	}

	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}
	
	
}