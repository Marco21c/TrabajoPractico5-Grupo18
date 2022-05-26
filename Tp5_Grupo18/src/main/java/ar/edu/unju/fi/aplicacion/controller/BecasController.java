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
import ar.edu.unju.fi.aplicacion.model.Beca;

@Controller
public class BecasController {
List<Beca> listaBecas = new ArrayList<>();    
	
	
	@GetMapping("/Beca")
	public String GetDocentePage(Model model){	
	Beca beca = new Beca();	
	model.addAttribute("beca",beca);
    return "nueva_beca";
    }
	
	@PostMapping("/saveBeca")
	public ModelAndView saveAlumno(@ModelAttribute("beca") Beca bec){
		ModelAndView modelAndView = new ModelAndView("tabla_becas");
		listaBecas.add(bec);
		modelAndView.addObject("becas",listaBecas);
		return modelAndView ;
	}
	
}