package ar.edu.unju.fi.aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactosController {
	@GetMapping("/contactanos")
	public String getAgendaPage(Model model){
		return "contacto";
}
}