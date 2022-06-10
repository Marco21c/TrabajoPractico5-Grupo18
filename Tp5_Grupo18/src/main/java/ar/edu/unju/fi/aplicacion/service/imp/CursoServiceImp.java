package ar.edu.unju.fi.aplicacion.service.imp;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.aplicacion.entity.Curso;
import ar.edu.unju.fi.aplicacion.repository.ICursosDAO;
import ar.edu.unju.fi.aplicacion.service.ICursoService;


@Service("CursoServiceImp")
public class CursoServiceImp implements ICursoService {

@Autowired 
ICursosDAO cursosDAOImp; 
    @Override
    public void guardarCurso(Curso curso) {
    	cursosDAOImp.save(curso);
    }    

	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public List<Curso> getListaCursos() {
		return cursosDAOImp.findAll();
	}

	@Override
	public void modificarCurso(Curso curso) {
		cursosDAOImp.save(curso);
	}

	@Override
	public void eliminarCurso(long codigo) {	
		cursosDAOImp.deleteById(codigo);
	}

	@Override
	public Curso buscarCurso(long codigo) {
		 Optional<Curso> curso = cursosDAOImp.findById(codigo);
		return curso.get();
	}

}
