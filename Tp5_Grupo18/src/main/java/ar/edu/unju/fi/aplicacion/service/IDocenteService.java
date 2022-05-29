package ar.edu.unju.fi.aplicacion.service;

import ar.edu.unju.fi.aplicacion.model.Docente;
import ar.edu.unju.fi.aplicacion.util.ListaDocente;

public interface IDocenteService {
	
	public Docente getDocente();
	public Boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	public ListaDocente getListaDocente();
	public Docente buscarDocente(int legajo);

}