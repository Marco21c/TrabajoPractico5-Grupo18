package ar.edu.unju.fi.aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdc")
public class IndexController {
    @GetMapping("/inicio")
    public String getIndexPage(Model model){
    	return "index";
    }
  
}
