package ar.edu.unju.fi.aplicacion.service;

import ar.edu.unju.fi.aplicacion.entity.Beca;
import ar.edu.unju.fi.aplicacion.util.ListaBecas;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;


public interface IBecaService {
	
	public Beca getBeca();
	public ListaBecas getListaBecas();
	public boolean agregarBeca(Beca beca);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(int codigo);
	public Beca buscarBeca(int codigo);
    public ListaCursos  getListaCursos();
}
