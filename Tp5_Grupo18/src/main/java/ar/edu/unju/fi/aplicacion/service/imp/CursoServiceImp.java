package ar.edu.unju.fi.aplicacion.service.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.entity.Curso;
import ar.edu.unju.fi.aplicacion.service.ICursoService;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;

@Service("CursoServiceImp")
public class CursoServiceImp implements ICursoService {
@Autowired
public ListaCursos listaCursos;

	@Override
	public Curso getCurso() {
		// TODO Auto-generated method stub
		return new Curso();
	}

	@Override
	public ListaCursos getListaCursos() {
		// TODO Auto-generated method stub
		return listaCursos;
	}

	@Override
	public boolean agregarCurso(Curso curso) {
		// TODO Auto-generated method stub
		boolean resp = listaCursos.getCursos().add(curso);
		return resp;
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		for(Curso c:listaCursos.getCursos()){
		 if(c.getCodigo()==curso.getCodigo()) {
			 c.setCategoria(curso.getCategoria());
			 c.setCodigo(curso.getCodigo());
			 c.setFechai(curso.getFechai());
			 c.setHora(curso.getHora());
			 c.setModalidad(curso.getModalidad());
			 c.setTitulo(curso.getTitulo());
		 }
		}
	}

	@Override
	public void eliminarCurso(int codigo) {
		// TODO Auto-generated method stub
		Optional<Curso> curso = listaCursos.getCursos().stream().filter(c-> c.getCodigo() == codigo).findFirst();
		listaCursos.getCursos().remove(curso.get());
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso = listaCursos.getCursos().stream().filter(c-> c.getCodigo() == codigo).findFirst();
		
		// TODO Auto-generated method stub
		return curso.get();
	}

}
