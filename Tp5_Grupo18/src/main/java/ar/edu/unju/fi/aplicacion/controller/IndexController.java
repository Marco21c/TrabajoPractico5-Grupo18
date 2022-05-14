package ar.edu.unju.fi.aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/inicio")
    public String getIndexPage(Model model){
    	return "index";
    }
    
    @RequestMapping("/contacto")
    public String getIndexPage(Model model){
    	return "contacto";
    }
}
