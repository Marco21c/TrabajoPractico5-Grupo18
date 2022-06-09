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

import ar.edu.unju.fi.aplicacion.entity.Alumno;
import ar.edu.unju.fi.aplicacion.service.IAlumnoService;
import ar.edu.unju.fi.aplicacion.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnosController {
	
	@Autowired
	@Qualifier("AlumnoServiceImpList")
	private IAlumnoService alumnoService;
	ListaAlumnos lista = new ListaAlumnos();
	
	private static final Log LOGGER = LogFactory.getLog(AlumnosController.class);
	
	@GetMapping("/nuevo")
	public String GetDocentePage(Model model){	
	//Alumno alumno = new Alumno();
	model.addAttribute("alumno", alumnoService.getAlumno());
    return "nuevo_alumno";
    }
	
	@PostMapping("/guardarAlumno")
	public ModelAndView BottonAgregar(@Validated @ModelAttribute("alumno") Alumno alu, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alu);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		if(alumnoService.guardarAlumno(alu)) {
			LOGGER.info("Se agrego alumno a la lista de alumnos");
		}
		
		
		return mav;
	}
	
	@GetMapping("/listaAlumnos")
	public ModelAndView getListaDocentesPage() {
		ModelAndView mav = new ModelAndView("tabla_alumnos");
		mav.addObject("alumnos", alumnoService.getListaAlumno().getAlumnos());
		return mav;
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarDocentePage(@PathVariable(value="dni")int dn){
		ModelAndView mav = new ModelAndView("edicion_alumno");
		Alumno alumno = alumnoService.buscarAlumno(dn);
		mav.addObject("alumno", alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		LOGGER.info("ocurrio un error"+alumno);
		ModelAndView mav = new ModelAndView("edicion_alumno");
		mav.addObject("alumno", alumno);
		return mav;
	}
	ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
	alumnoService.modificarAlumno(alumno);
	return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarDocente(@PathVariable("legajo")int dni) {
		ModelAndView mav = new ModelAndView("redirect:/alumno/listaAlumnos");
		alumnoService.eliminarAlumno(dni);
				return mav;
	}
	
}