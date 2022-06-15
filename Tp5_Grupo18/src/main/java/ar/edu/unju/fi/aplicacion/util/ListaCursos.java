package ar.edu.unju.fi.aplicacion.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.aplicacion.entity.Curso;
@Component
public class ListaCursos {
  ArrayList<Curso> cursos;

public List<Curso> getCursos() {
	return cursos;
}


public void setCursos(ArrayList<Curso> cursos) {
	this.cursos = cursos;
}


/*public ListaCursos(){
	cursos = new ArrayList<Curso>();
	cursos.add(new Curso(1,"Marketing","Negocios",LocalDate.of(2022, 8, 10),3,"presencial"));
	cursos.add(new Curso(1,"Algebra","Matematicas",LocalDate.of(2022, 7, 11),2,"presencial"));
}

*/
}
