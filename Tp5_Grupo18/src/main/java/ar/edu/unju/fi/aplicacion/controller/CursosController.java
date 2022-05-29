package ar.edu.unju.fi.aplicacion.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.aplicacion.model.Curso;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;

@Controller
public class CursosController {
private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
ListaCursos listaCursos = new ListaCursos();
	
	@GetMapping("/Cursos")
	public String GetDocentePage(Model model){	
	Curso curso = new Curso();	
	model.addAttribute("curso",curso);
    return "nuevo_Curso";
    }
	
	@PostMapping("/saveCurso")
	public ModelAndView saveAlumno(@Validated @ModelAttribute("curso") Curso curs,  BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación.");
			ModelAndView modelAndView = new ModelAndView("nuevo_Curso");
			modelAndView.addObject("curso", curs);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("tabla_cursos");
		if(listaCursos.getCursos().add(curs)) {
			LOGGER.info("Se agrego curso a la lista de cursos.");
		}
		modelAndView.addObject("cursos",listaCursos.getCursos());
		return modelAndView ;
	}
	@GetMapping("/listaCursos")
	public String getListaCursosPage(Model model) {
		model.addAttribute("cursos", listaCursos.getCursos());
		return "tabla_cursos";
	}
	
	
}