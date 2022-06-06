package ar.edu.unju.fi.aplicacion.service;

import ar.edu.unju.fi.aplicacion.model.Beca;
import ar.edu.unju.fi.aplicacion.util.ListaBecas;


public interface IBecaService {
	
	public Beca getBeca();
	public ListaBecas getListaBecas();
	public boolean agregarBeca(Beca beca);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(int codigo);
	public Beca buscarBeca(int codigo);

}
