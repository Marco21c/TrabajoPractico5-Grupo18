package ar.edu.unju.fi.aplicacion.controller;

import java.util.ArrayList;
import java.util.List;


import org.apache.juli.logging.LogFactory;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.aplicacion.model.Docente;
import ar.edu.unju.fi.aplicacion.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	//private static final Log LOGGER = (Log) LogFactory.getLog(DocenteController.class);
	
	ListaDocente listaDocente = new ListaDocente();
	
	@GetMapping("/nuevo")
	public String GetDocentePage(Model model){	
	Docente docente = new Docente();
	model.addAttribute("docente", docente);
    return "nuevo_docente";
    }
	
	@PostMapping("/guardarDocente")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("docente") Docente doc, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", doc);
			return mav;
		}
		ModelAndView mav = new ModelAndView("tabla_docentes");
		if(listaDocente.getDocentes().add(doc)) {
			//LOGGER.info("Se agrego docente a la lista de docentes");
		}
		
		mav.addObject("docentes", listaDocente.getDocentes());
		return mav;
	}
	
}
