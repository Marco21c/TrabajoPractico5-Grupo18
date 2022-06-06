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
import ar.edu.unju.fi.aplicacion.model.Beca;
import ar.edu.unju.fi.aplicacion.service.IBecaService;
import ar.edu.unju.fi.aplicacion.util.ListaBecas;
import ar.edu.unju.fi.aplicacion.util.ListaCursos;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.util.Optional;

@Controller
@RequestMapping("/beca")
public class BecasController {
	//ListaBecas listaBecas = new ListaBecas();    
	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);

	@Autowired
	@Qualifier("BecaServiceImp")
	private IBecaService becaService;
	
	@GetMapping("/nuevo")
	public String GetBecaPage(Model model){	
	//model.addAttribute("beca",new Beca());
	ListaCursos listacurso = new ListaCursos();
	model.addAttribute("beca", becaService.getBeca());
    return "nueva_beca";
    }
	
	@PostMapping("/guardarBeca")
	public ModelAndView saveAlumno(@Validated @ModelAttribute("beca") Beca bec, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView modelAndview = new ModelAndView("nueva_beca");
			modelAndview.addObject("beca", bec);
			return modelAndview;
		}
		ModelAndView modelAndView = new ModelAndView("redirect:beca/listaBecas");
		if(becaService.agregarBeca(bec)) {
			LOGGER.info("Se guardó un objeto beca en la lista de becas");
		}
		modelAndView.addObject("becas",becaService.getListaBecas());
		return modelAndView ;
		}
	
		@GetMapping("/listaBecas")
		public String GetlistaBecaPage(Model model){	
		 model.addAttribute("becas", becaService.getListaBecas().getBecas());
	    return "tabla_becas";
	    }
		
		@GetMapping("/editarBeca/{codigo}")
		public ModelAndView getEditarBeca (@PathVariable(value="codigo")int cod) {
			ModelAndView mav = new ModelAndView("editar_beca");
			Beca bec = becaService.buscarBeca(cod);
			mav.addObject("beca", bec);
			return mav;
		}
		@PostMapping("/modificar")
		public ModelAndView modificarCurso(@Validated @ModelAttribute("beca") Beca bec,  BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				LOGGER.info("Ocurrio un error en la validacion de "+bec);
				ModelAndView mav = new ModelAndView("edicion_beca");
				mav.addObject("beca", bec);
			}
			 LOGGER.info("Se modifico el curso"+bec); 
			ModelAndView mav = new ModelAndView("redirect:/beca/listaBecas");
			becaService.modificarBeca(bec);
			return mav;
		}
		@GetMapping("/eliminarBeca/{codigo}")
		public ModelAndView getEliminarCurso(@PathVariable(value="codigo")int cod){
			LOGGER.info("Se elimino el curso con codigo: "+cod); 
			ModelAndView mav = new ModelAndView("redirect:/beca/listaBeca");
			becaService.eliminarBeca(cod);
			return mav;
		}
}