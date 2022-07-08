package ar.edu.unju.fi.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.aplicacion.entity.Alumno;

public interface IAlumnosDAO extends JpaRepository<Alumno,Integer>{
	public List<Alumno> findByEstado(boolean estado); 

}
