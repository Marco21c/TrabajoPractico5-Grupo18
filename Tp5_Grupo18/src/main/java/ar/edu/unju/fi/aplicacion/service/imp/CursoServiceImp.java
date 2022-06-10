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
	// TODO Auto-generated method stub
    	cursosDAOImp.save(curso);
    }    

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public List<Curso> getListaCursos() {
		// TODO Auto-generated method stub
		 
		return cursosDAOImp.findAll();
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		
		/*for(Curso c:listaCursos.getCursos()){
		 if(c.getCodigo()==curso.getCodigo()) {
			 c.setCategoria(curso.getCategoria());
			 c.setCodigo(curso.getCodigo());
			 c.setFechai(curso.getFechai());
			 c.setHora(curso.getHora());
			 c.setModalidad(curso.getModalidad());
			 c.setTitulo(curso.getTitulo());
		 }
		}*/
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
