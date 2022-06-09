package ar.edu.unju.fi.aplicacion.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.aplicacion.entity.Alumno;
import ar.edu.unju.fi.aplicacion.service.IAlumnoService;
import ar.edu.unju.fi.aplicacion.util.ListaAlumnos;
@Service("AlumnoServiceImpList")
public class AlumnoServicelmp implements IAlumnoService {
	
	@Autowired
	private ListaAlumnos listaAlumno;

	@Override
	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

	@Override
	public Boolean guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return listaAlumno.getAlumnos().add(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		for(Alumno alu: listaAlumno.getAlumnos()) {
			if(alu.getDni() == alumno.getDni()) {
				alu.setApellido(alumno.getApellido());
				alu.setNombre(alumno.getNombre());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliminarAlumno(int dni) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		listaAlumno.getAlumnos().remove(alumno.get());

	}

	@Override
	public ListaAlumnos getListaAlumno() {
		// TODO Auto-generated method stub
		return listaAlumno;
	}

	@Override
	public Alumno buscarAlumno(int dni) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno = listaAlumno.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
		return alumno.get();
	}

}
