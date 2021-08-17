package com.dussan.HolaSpring.webb;

import com.dussan.HolaSpring.dao.PersonaDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired //Inyectando interface PersonaDao
    private PersonaDao personaDao;

    
    
    @GetMapping("/")
    public String inicio(Model model) {
        
        var personas = personaDao.findAll();
        log.info("Ejecutando en controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

}
