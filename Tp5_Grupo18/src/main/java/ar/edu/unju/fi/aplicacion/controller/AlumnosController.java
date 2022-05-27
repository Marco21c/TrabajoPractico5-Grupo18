package ar.edu.unju.fi.aplicacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.aplicacion.model.Alumno;
import ar.edu.unju.fi.aplicacion.util.ListaAlumnos;

@Controller
public class AlumnosController {

ListaAlumnos lista = new ListaAlumnos();	
	
	@GetMapping("/Alumno")
	public String GetAlumnosPage(Model model){	
	Alumno alumno = new Alumno();	
	model.addAttribute("alumno",alumno);
    return "nuevo_alumno";
    }
	
	@PostMapping("/saveAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("alumno") Alumno alu){
		ModelAndView modelAndView = new ModelAndView("tabla_alumnos");
		lista.getAlumnos().add(alu);	
		modelAndView.addObject("alumno",lista.getAlumnos());
		return modelAndView ;
	}
	
}