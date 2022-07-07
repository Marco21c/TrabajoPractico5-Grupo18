package ar.edu.unju.fi.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.aplicacion.entity.Docente;

public interface IDocentesDAO extends JpaRepository<Docente,Long>{

}
