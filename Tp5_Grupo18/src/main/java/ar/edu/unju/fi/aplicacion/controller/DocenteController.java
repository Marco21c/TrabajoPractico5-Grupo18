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

import ar.edu.unju.fi.aplicacion.model.Docente;
@Controller
public class DocenteController {
    
	@GetMapping("/Docente")
	public String GetDocentePage(Model model){	
	Docente docente = new Docente();	
	model.addAttribute("docente",docente);
	List<Docente> listdocentes = new ArrayList<>();
	listdocentes.add(docente);
	model.addAttribute("lista", listdocentes);
    return "nuevo_docente";
    }
	
	@PostMapping("/saveDocente")
	public ModelAndView BottonAgregar(@ModelAttribute("docente") Docente doc ){
		ModelAndView modelAndView = new ModelAndView("tabla_docentes");
		modelAndView.addObject("docente",doc);
		
		return modelAndView ;
	}
	
}
