package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.model.Beca;
import ar.edu.unju.fi.aplicacion.service.IBecaService;
import ar.edu.unju.fi.aplicacion.util.ListaBecas;

@Service("BecaServiceImp")
public class BecaServicelmp implements IBecaService {
	
	@Autowired
	public ListaBecas listaBecas;

	@Override
	public Beca getBeca() {
		// TODO Auto-generated method stub
		return new Beca();
	}

	@Override
	public ListaBecas getListaBecas() {
		// TODO Auto-generated method stub
		return listaBecas;
	}

	@Override
	public boolean agregarBeca(Beca beca) {
		// TODO Auto-generated method stub
		return listaBecas.getBecas().add(beca);
	}

	@Override
	public void modificarBeca(Beca beca) {
		// TODO Auto-generated method stub
		for(Beca b:listaBecas.getBecas()) {
			if(b.getCodigo()==beca.getCodigo()) {
				b.setCurso(beca.getCurso());
				b.setFecha_inicio(beca.getFecha_inicio());
				b.setFecha_cierre(beca.getFecha_cierre());
				b.setEstado(beca.getEstado());
			}
		}

	}

	@Override
	public void eliminarBeca(int codigo) {
		// TODO Auto-generated method stub
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(b -> b.getCodigo() == codigo).findFirst();
		listaBecas.getBecas().remove(beca.get());
	}

	@Override
	public Beca buscarBeca(int codigo) {
		// TODO Auto-generated method stub
		Optional<Beca> beca = listaBecas.getBecas().stream().filter(b -> b.getCodigo() == codigo).findFirst();
		return beca.get();
	}

}
