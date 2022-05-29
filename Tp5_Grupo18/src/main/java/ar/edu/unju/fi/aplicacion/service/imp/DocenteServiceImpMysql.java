package ar.edu.unju.fi.aplicacion.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.model.Docente;
import ar.edu.unju.fi.aplicacion.service.IDocenteService;
import ar.edu.unju.fi.aplicacion.util.ListaDocente;
@Service("DocenteServiceImpMysql")
public class DocenteServiceImpMysql implements IDocenteService {

	@Override
	public Docente getDocente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean guardarDocente(Docente docente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDocente(Docente docente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListaDocente getListaDocente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// TODO Auto-generated method stub
		return null;
	}

}
