package ar.edu.unju.fi.aplicacion.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.aplicacion.entity.Beca;
import ar.edu.unju.fi.aplicacion.service.IBecaService;
import ar.edu.unju.fi.aplicacion.service.ICursoService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/beca")
public class BecasController {
	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);

	@Autowired
	@Qualifier("BecaServiceImp")
	private IBecaService becaService;
	@Autowired
	@Qualifier("CursoServiceImp")
	private ICursoService cursoService;
	
	@GetMapping("/nuevo")
	public String GetBecaPage(Model model){	
	model.addAttribute("beca", becaService.getBeca());
	model.addAttribute("listaCurso",cursoService.getListaCursos());
    return "nueva_beca";
    }
	
	@PostMapping("/guardarBeca")
	public ModelAndView saveBeca(@Validated @ModelAttribute("beca") Beca bec, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("nueva_beca");
			modelAndview.addObject("beca", bec);
			modelAndview.addObject("listaCurso",cursoService.getListaCursos());
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/beca/listaBecas");
		if(becaService.agregarBeca(bec)) {
		LOGGER.info("Se guardó un objeto beca en la lista de becas");
		}
		modelAndView.addObject("becas",becaService.getListaBecas());
		return modelAndView ;
		}
	
		@GetMapping("/listaBecas")
		public String GetlistaBecaPage(Model model){	
		 model.addAttribute("becas", becaService.getListaBecas());
	    return "tabla_becas";
	    }
		
		@GetMapping("/editarBeca/{codigo}")
		public ModelAndView getEditarBeca (@PathVariable(value="codigo")int cod) {
			ModelAndView mav = new ModelAndView("edicion_beca");
			Beca bec = becaService.buscarBeca(cod);
			mav.addObject("beca", bec);
			mav.addObject("listaCurso",cursoService.getListaCursos());
			return mav;
		}
		@PostMapping("/modificar")
		public ModelAndView modificarBeca(@Validated @ModelAttribute("beca") Beca bec,  BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				LOGGER.info("Ocurrio un error en la validacion de "+bec);
				ModelAndView mav = new ModelAndView("edicion_beca");
				mav.addObject("beca", bec);
				mav.addObject("listaCurso",cursoService.getListaCursos());
			}
			 LOGGER.info("Se modifico el curso"+bec.getCodigo()); 
			ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
			becaService.modificarBeca(bec);
			return mav;
		}
		
		@GetMapping("/eliminarBeca/{codigo}")
		public ModelAndView getEliminarBeca(@PathVariable(value="codigo")int cod){
			LOGGER.info("Se elimino la beca con codigo: "+cod); 
			ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
			becaService.eliminarBeca(cod);
			return mav;
		}
}