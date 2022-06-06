package ar.edu.unju.fi.aplicacion.service;

import ar.edu.unju.fi.aplicacion.model.Alumno;
import ar.edu.unju.fi.aplicacion.util.ListaAlumnos;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public Boolean guardarAlumno(Alumno alu);
	public void modificarAlumno(Alumno alumno);
	public void eliminarAlumno(int dni);
	public ListaAlumnos getListaAlumno();
	public Alumno buscarAlumno(int dni);

}
