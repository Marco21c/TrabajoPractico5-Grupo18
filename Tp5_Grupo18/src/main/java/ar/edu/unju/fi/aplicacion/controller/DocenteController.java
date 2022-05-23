package ar.edu.unju.fi.aplicacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.aplicacion.model.Docente;
@Controller
public class DocenteController {
	List<Docente> listdocentes = new ArrayList<>(); 
	
	@GetMapping("/Docente")
	public String GetDocentePage(Model model){	
	Docente docente = new Docente();	
	model.addAttribute("docente",docente);
    return "nuevo_docente";
    }
	
	@PostMapping("/saveDocente")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("docente") Docente doc, BindingResult bindingResult ){
		if(bindingResult.hasErrors()) {
		ModelAndView modelAndView = new ModelAndView("tabla_docentes");
		listdocentes.add(doc);
		modelAndView.addObject("docente",listdocentes);
		return modelAndView ;
		}
		
		ModelAndView modelAndView = new ModelAndView("tabla_docentes");
		ListDocente listdocentes = new ListDocente();
		
	}
	
}
