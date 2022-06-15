package ar.edu.unju.fi.aplicacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.aplicacion.entity.Curso;

public interface ICursosDAO extends JpaRepository<Curso,Long>{

	public List<Curso> findByEstado(boolean estado);
}
