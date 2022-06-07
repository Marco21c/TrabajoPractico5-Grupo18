package ar.edu.unju.fi.aplicacion.controller;

import java.util.ArrayList;
import java.util.List;

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

import ar.edu.unju.fi.aplicacion.model.Docente;
import ar.edu.unju.fi.aplicacion.service.IDocenteService;
import ar.edu.unju.fi.aplicacion.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	//ListaDocente listaDocente = new ListaDocente();
	
	@GetMapping("/nuevo")
	public String GetDocentePage(Model model){	
	//Docente docente = new Docente();
	model.addAttribute("docente", docenteService.getDocente());
	model.addAttribute("listaCursos",docenteService.getListaCursos().getCursos());
    return "nuevo_docente";
    }
	
	@PostMapping("/guardarDocente")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("docente") Docente doc, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", doc);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		if(docenteService.guardarDocente(doc)) {
			LOGGER.info("Se agrego docente a la lista de docentes");
		}
		
		//mav.addObject("docentes", docenteService.getListaDocente().getDocentes()); 
		return mav;
	}
	
	@GetMapping("/listaDocentes")
	public ModelAndView getListaDocentesPage() {
		ModelAndView mav = new ModelAndView("tabla_docentes");
		mav.addObject("docentes", docenteService.getListaDocente().getDocentes());
		return mav;
	}
	
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="legajo")int lg){
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(lg);
		mav.addObject("docente", docente);
		mav.addObject("listaCursos",docenteService.getListaCursos().getCursos());
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		LOGGER.info("ocurrio un error"+docente);
		ModelAndView mav = new ModelAndView("edicion_docente");
		mav.addObject("docente", docente);
		return mav;
	}
	ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
	docenteService.modificarDocente(docente);
	return mav;
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable("legajo")int legajo) {
		ModelAndView mav = new ModelAndView("redirect:/docente/listaDocentes");
		docenteService.eliminarDocente(legajo);
				return mav;
	}
}
