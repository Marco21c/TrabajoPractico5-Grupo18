package ar.edu.unju.fi.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.aplicacion.entity.Beca;

public interface IBecasDAO extends JpaRepository<Beca,Long> {

	public List<Beca> findByEstado(boolean estado); 
}
