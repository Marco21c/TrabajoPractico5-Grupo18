package ar.edu.unju.fi.aplicacion.service;

import ar.edu.unju.fi.aplicacion.model.Curso;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;

public interface ICursoService {
  
	public Curso getCurso();
	public ListaCursos getListaCursos();
	public boolean agregarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
	public Curso buscarCurso(int codigo);
}
