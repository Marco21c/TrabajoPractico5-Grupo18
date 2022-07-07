package ar.edu.unju.fi.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.aplicacion.entity.Alumno;

public interface IAlumnosDAO extends JpaRepository<Alumno,Long>{

}
