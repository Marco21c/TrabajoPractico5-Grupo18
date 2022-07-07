package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.entity.Docente;
import ar.edu.unju.fi.aplicacion.service.IDocenteService;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;
import ar.edu.unju.fi.aplicacion.util.ListaDocente;
@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {
	//inyeccion de objeto
	@Autowired
	
	@Autowired
    public ListaCursos listaCursos;
	@Override
	public Docente getDocente() {
		// retorna un objeto de la clase alumno
		return new Docente();
	}

	@Override
	public Boolean guardarDocente(Docente docente) {
		// guarda un objeto alumno en la lista de alumnos
		boolean respuesta = listaDocente.getDocentes().add(docente);
		return respuesta;
	}

	@Override
	public void modificarDocente(Docente docente) {
		// buscar docente con el legajo y actualizar sus atributos
		for(Docente doc: listaDocente.getDocentes()) {
			if(doc.getLegajo() == docente.getLegajo()) {
				doc.setApellido(docente.getApellido());
				doc.setNombre(docente.getNombre());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
				doc.setCurso(docente.getCurso());
			}
		}

	}

	@Override
	public void eliminarDocente(int legajo) {
		// TODO busca al docente, devuelve el objeto asociado, y se procede a eliminar de la lista docente
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
		listaDocente.getDocentes().remove(docente.get());

	}

	@Override
	public ListaDocente getListaDocente() {
		// retorna el objeto que accede a la lista de docentes
		return listaDocente;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// busca un docente por legajo y devuelve el objeto asociado al legajo
		Optional<Docente> docente = listaDocente.getDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
		return docente.get();
	}

	@Override
	public ListaCursos getListaCursos() {
		// TODO Auto-generated method stub
		return listaCursos;
	}

}
