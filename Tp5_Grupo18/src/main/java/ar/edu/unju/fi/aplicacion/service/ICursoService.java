package ar.edu.unju.fi.aplicacion.service;

import java.util.List;
import ar.edu.unju.fi.aplicacion.entity.Curso;

public interface ICursoService {
    public boolean guardarCurso(Curso curso);
	public Curso getCurso();
	public List<Curso> getListaCursos();
	public void modificarCurso(Curso curso);
	public void eliminarCurso(long codigo);
	public Curso buscarCurso(long codigo);
}
