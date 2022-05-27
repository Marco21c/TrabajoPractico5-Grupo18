package ar.edu.unju.fi.aplicacion.util;

import java.util.ArrayList;
import ar.edu.unju.fi.aplicacion.model.Alumno;

public class ListaAlumnos {
	ArrayList<Alumno> alumnos;
	
	public ListaAlumnos(){
		alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno(01,"Perez","Jose","JosePerez@hotmail.com",3881));
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
