package com.dussan.HolaSpring.web;

import com.dussan.HolaSpring.domain.Persona;
import com.dussan.HolaSpring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired //Inyectando interface PersonaDao
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaService.ListarPersonas();
        log.info("Ejecutando en controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {

        return "modificar";

    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {

        personaService.guardar(persona);
        return "redirect:/"; //para redireccionar a la pagina de inicio 
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";

    }
    
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        
        personaService.eliminar(persona);
        
        return "redirect:/";
        
    }
    
}
