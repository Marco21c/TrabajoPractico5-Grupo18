package ar.edu.unju.fi.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.aplicacion.entity.Docente;

public interface IDocentesDAO extends JpaRepository<Docente,Integer>{
              
	    public List<Docente> findAllByEstado(boolean estado);
}
