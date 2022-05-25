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
import ar.edu.unju.fi.aplicacion.util.ListaDocente;
@Controller
public class DocenteController {
	//List<Docente> listdocentes = new ArrayList<>(); 
	
	@GetMapping("/Docente")
	public String GetDocentePage(Model model){	
	Docente docente = new Docente();	
	model.addAttribute("docente",docente);
    return "nuevo_docente";
    }
	
	@PostMapping("/saveDocente")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult ){
		if(bindingResult.hasErrors()) {
		ModelAndView modelAndView = new ModelAndView("nuevo_docente");
		modelAndView.addObject("docente",docente);
		return modelAndView ;
		}
		
		ModelAndView modelAndView = new ModelAndView("tabla_docentes");
		ListaDocente listDocentes = new ListaDocente();
		if (listDocentes.getDocentes().add(docente)) {
			//LOOGER.inf("Se agrego un docente al arraylist de docente");
		}
		
		modelAndView.addObject("tabla_docentes", listDocentes.getDocentes());
		return modelAndView;
	}
	
}
