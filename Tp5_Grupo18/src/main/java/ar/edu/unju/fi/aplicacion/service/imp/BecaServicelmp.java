package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.entity.Beca;
import ar.edu.unju.fi.aplicacion.entity.Curso;
import ar.edu.unju.fi.aplicacion.repository.IBecasDAO;
import ar.edu.unju.fi.aplicacion.repository.ICursosDAO;
import ar.edu.unju.fi.aplicacion.service.IBecaService;

@Service("BecaServiceImp")
public class BecaServicelmp implements IBecaService {
	
	@Autowired
	IBecasDAO becasDAOImp;

	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public List<Beca> getListaBecas() {
		// TODO Auto-generated method stub
		return becasDAOImp.findByEstado(true);
	}

	@Override
	public boolean agregarBeca(Beca beca) {
		beca.setEstado(true);
		if(becasDAOImp.save(beca)!= null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarBeca(Beca beca) {
		// TODO Auto-generated method stub
		beca.setEstado(true);
       becasDAOImp.save(beca);
	}

	@Override
	public void eliminarBeca(long codigo) {
		// TODO Auto-generated method stub
		Beca beca = buscarBeca(codigo);
	    beca.setEstado(false);
	    becasDAOImp.save(beca);
	}

	@Override
	public Beca buscarBeca(long codigo) {
		Optional<Beca> beca =becasDAOImp.findById(codigo);
		return beca.get();
	}

}
