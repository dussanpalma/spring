package com.dussan.HolaSpring.web;

import com.dussan.HolaSpring.domain.Persona;
import com.dussan.HolaSpring.servicio.PersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired //Inyectando interface PersonaDao
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {

        var personas = personaService.ListarPersonas();
        log.info("Ejecutando en controlador Spring MVC");
        log.info("Usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {

        return "modificar";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()){
            
            return "modificar";
            
        }

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
