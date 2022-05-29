package ar.edu.unju.fi.aplicacion.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.aplicacion.model.Beca;
import ar.edu.unju.fi.aplicacion.model.Curso;
import ar.edu.unju.fi.aplicacion.util.ListaBecas;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.util.Optional;

@Controller
public class BecasController {
ListaBecas listaBecas = new ListaBecas();    
	
private static final Log LOGGER = LogFactory.getLog(DocenteController.class);

	@GetMapping("/Beca")
	public String GetBecaPage(Model model){	
	model.addAttribute("beca",new Beca());
	ListaCursos listacurso = new ListaCursos();
	model.addAttribute("listaCurso", listacurso.getCursos());
    return "nueva_beca";
    }
	
	@PostMapping("/saveBeca")
	public ModelAndView saveAlumno(@Validated @ModelAttribute("beca") Beca bec, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("nueva_beca");
			modelAndview.addObject("beca", bec);
			ListaCursos listacurso = new ListaCursos();
			modelAndview.addObject("listaCurso", listacurso.getCursos());
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("tabla_becas");
		ListaCursos listacurso = new ListaCursos();
		Optional<Curso> curso = listacurso.getCursos().stream().filter(c -> c.getCodigo() == bec.getCurso().getCodigo()).findFirst();
		bec.setCurso(curso.get());
		if(listaBecas.getBecas().add(bec)) {
			LOGGER.info("Se guardó un objeto beca en la lista de becas");
		}
		modelAndView.addObject("becas",listaBecas.getBecas());
		return modelAndView ;
	}
	
	@GetMapping("/listaBeca")
	public String GetlistaBecaPage(Model model){	
	 model.addAttribute("becas", listaBecas.getBecas());
    return "tabla_becas";
    }
}