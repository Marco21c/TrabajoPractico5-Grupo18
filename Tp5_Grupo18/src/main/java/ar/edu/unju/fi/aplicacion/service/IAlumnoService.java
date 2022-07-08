package ar.edu.unju.fi.aplicacion.service;

import java.util.List;

import ar.edu.unju.fi.aplicacion.entity.Alumno;

public interface IAlumnoService {
	
	public Alumno getAlumno();
	public Boolean guardarAlumno(Alumno alu);
	public void modificarAlumno(Alumno alumno);
	public void eliminarAlumno(int dni);
	public List<Alumno> getListaAlumno();
	public Alumno buscarAlumno(int dni);

}
