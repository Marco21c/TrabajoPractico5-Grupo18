package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.aplicacion.entity.Docente;
import ar.edu.unju.fi.aplicacion.repository.ICursosDAO;
import ar.edu.unju.fi.aplicacion.repository.IDocentesDAO;
import ar.edu.unju.fi.aplicacion.service.IDocenteService;

@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {
	//inyeccion de objeto
	@Autowired
	IDocentesDAO docenteDAOImp;
	@Autowired
    ICursosDAO cursoDAOImp;
	@Override
	public Docente getDocente() {
		// retorna un objeto de la clase alumno
		return new Docente();
	}

	@Override
	public Boolean guardarDocente(Docente docente) {
		// guarda un objeto alumno en la lista de alumnos
		docente.setEstado(true);
		if(docenteDAOImp.save(docente)!=null) {
			 return true;
		}
		return false;
	}

	@Override
	public void modificarDocente(Docente docente) {
		// buscar docente con el legajo y actualizar sus atributos
		docente.setEstado(true);
		docenteDAOImp.save(docente);
	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO busca al docente, devuelve el objeto asociado, y se procede a eliminar de la lista docente
		  Docente docente = buscarDocente(legajo);
          docente.setEstado(false);
          docenteDAOImp.save(docente);
	}

	@Override
	public List<Docente> getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		return docenteDAOImp.findAllByEstado(true);
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// busca un docente por legajo y devuelve el objeto asociado al legajo
		Optional<Docente> docente = docenteDAOImp.findById(legajo);
		return docente.get();
	}

}
