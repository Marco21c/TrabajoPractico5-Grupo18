package ar.edu.unju.fi.aplicacion.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.aplicacion.model.Curso;

@Controller
public class CursosController {
List<Curso> listaCursos = new ArrayList<>();    
	
	@GetMapping("/Cursos")
	public String GetDocentePage(Model model){	
	Curso curso = new Curso();	
	model.addAttribute("curso",curso);
    return "nuevo_Curso";
    }
	
	@PostMapping("/saveCurso")
	public ModelAndView saveAlumno(@ModelAttribute("curso") Curso curs){
		ModelAndView modelAndView = new ModelAndView("tabla_cursos");
		listaCursos.add(curs);
		modelAndView.addObject("cursos",listaCursos);
		return modelAndView ;
	}
	
}