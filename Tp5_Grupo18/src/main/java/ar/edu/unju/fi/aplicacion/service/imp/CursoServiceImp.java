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
    public boolean guardarCurso(Curso curso) {
    	curso.setEstado(true);
    	
    	if(cursosDAOImp.save(curso)!=null) {
    		return true;
    	}
    	
    	return false;
    }    

	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public List<Curso> getListaCursos() {
		return cursosDAOImp.findByEstado(true);
	}

	@Override
	public void modificarCurso(Curso curso) {
		curso.setEstado(true);
		cursosDAOImp.save(curso);
	}

	@Override
	public void eliminarCurso(long codigo) {	
		Curso curso = buscarCurso(codigo);
	curso.setEstado(false);
		cursosDAOImp.save(curso);
	//cursosDAOImp.deleteById(codigo);
	}

	@Override
	public Curso buscarCurso(long codigo) {
		 Optional<Curso> curso = cursosDAOImp.findById(codigo);
		return curso.get();
	}

}
