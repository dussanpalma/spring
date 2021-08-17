package com.dussan.HolaSpring.web;

import com.dussan.HolaSpring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
