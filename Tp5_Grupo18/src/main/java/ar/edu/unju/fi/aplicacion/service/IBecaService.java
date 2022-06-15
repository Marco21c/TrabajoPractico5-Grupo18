package ar.edu.unju.fi.aplicacion.service;

import java.util.List;

import ar.edu.unju.fi.aplicacion.entity.Beca;
import ar.edu.unju.fi.aplicacion.entity.Curso;


public interface IBecaService {
	
	public Beca getBeca();
	public List<Beca> getListaBecas();
	public boolean agregarBeca(Beca beca);
	public void modificarBeca(Beca beca);
	public void eliminarBeca(long codigo);
	public Beca buscarBeca(long codigo);
;
}
