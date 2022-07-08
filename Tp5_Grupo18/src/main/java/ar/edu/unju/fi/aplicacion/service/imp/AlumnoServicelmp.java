package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.aplicacion.entity.Alumno;
import ar.edu.unju.fi.aplicacion.repository.IAlumnosDAO;
import ar.edu.unju.fi.aplicacion.service.IAlumnoService;
@Service("AlumnoServiceImpList")
public class AlumnoServicelmp implements IAlumnoService {
	
	@Autowired
	IAlumnosDAO alumnosDAOImp;

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public Boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumno.setEstado(true);
		if(alumnosDAOImp.save(alumno)!=null){
			return true;
			
		}
		return false;
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumno.setEstado(true);
		alumnosDAOImp.save(alumno);
	}

	@Override
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		Alumno alumno =buscarAlumno(dni);
        alumno.setEstado(false);
        alumnosDAOImp.save(alumno);
	}

	@Override
	public List<Alumno> getListaAlumno() {
		// TODO Auto-generated method stub
		return alumnosDAOImp.findByEstado(true);
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno = alumnosDAOImp.findById(dni);
		return alumno.get();
	}

}
