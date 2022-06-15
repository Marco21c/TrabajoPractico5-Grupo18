package ar.edu.unju.fi.aplicacion.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.aplicacion.entity.Curso;
import ar.edu.unju.fi.aplicacion.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursosController {
private static final Log LOGGER = LogFactory.getLog(CursosController.class);

	@Autowired
    @Qualifier("CursoServiceImp")
    private ICursoService cursoService;

	@GetMapping("/nuevo")
	public String GetCursoPage(Model model){		
	model.addAttribute("curso",cursoService.getCurso());
    return "nuevo_Curso";
    }
	
	@PostMapping("/guardarCurso")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso") Curso curs,  BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación.");
			ModelAndView modelAndView = new ModelAndView("nuevo_Curso");
			modelAndView.addObject("curso", curs);
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/curso/listaCursos");
		if(cursoService.guardarCurso(curs)) {
			LOGGER.info("Se agrego curso a la lista de cursos.");
		}
		
		modelAndView.addObject("cursos",cursoService.getListaCursos());
		return modelAndView ;
	}
	@GetMapping("/listaCursos")
	public String getListaCursosPage(Model model) {
		model.addAttribute("cursos", cursoService.getListaCursos());
		return "tabla_cursos";
	}
	
@GetMapping("/editarCurso/{codigo}")
	public ModelAndView getEditarCurso (@PathVariable(value="codigo")int cod) {
		ModelAndView mAv = new ModelAndView("editar_curso");
		Curso curs = cursoService.buscarCurso(cod);
		mAv.addObject("curso", curs);
		return mAv;
	}
	@PostMapping("/modificar")
	public ModelAndView modificarCurso(@Validated @ModelAttribute("curso") Curso curs,  BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Ocurrio un error en la validacion de "+curs);
			ModelAndView mav = new ModelAndView("editar_curso");
			mav.addObject("curso", curs);
		}
		 LOGGER.info("Se modifico el curso"+curs); 
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		cursoService.modificarCurso(curs);
		return mav;
	}
	@GetMapping("/eliminarCurso/{codigo}")
	public ModelAndView getEliminarCurso(@PathVariable(value="codigo")int cod){
		LOGGER.info("Se elimino el curso con codigo: "+cod); 
		ModelAndView mav = new ModelAndView("redirect:/curso/listaCursos");
		cursoService.eliminarCurso(cod);
		return mav;
	}
}