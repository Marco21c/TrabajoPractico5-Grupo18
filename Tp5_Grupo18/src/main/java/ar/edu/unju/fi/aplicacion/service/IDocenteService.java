package ar.edu.unju.fi.aplicacion.service;

import java.util.List;

import ar.edu.unju.fi.aplicacion.entity.Docente;

public interface IDocenteService {
	
	public Docente getDocente();
	public Boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	public List<Docente> getListaDocente();
	public Docente buscarDocente(int legajo);
}
