package com.dussan.HolaSpring;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {

        var mensaje = "Hola Mundo Con Thymeleaf";

// ---------------- OBJETOS PERSONAS -------------------------//        
        var persona = new Persona();
        persona.setNombre("Dussan");
        persona.setApellido("Palma");
        persona.setEmail("dussanpalma@hotmail.com");
        persona.setTelefono("3043805252");

        var persona2 = new Persona();
        persona2.setNombre("Gissell");
        persona2.setApellido("Nieto");
        persona2.setEmail("gissenieto@hotmail.com");
        persona2.setTelefono("3054541254");

// --------------- CREACIÓN DE LISTA PERSONAS -----------------//        
        //Forma 1
//        var personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);

        // Forma 2
        var personas = Arrays.asList(persona, persona2);

        // Lista Vacia Ejemplo
//        var personas= new ArrayList();

// ----------------- CLASE MODEL ----------------------//        
        log.info("Ejecutando en controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);

//      Mostrando una sola persona       
//      model.addAttribute("persona", persona);
//      Mostrando una lista de personas
        model.addAttribute("personas", personas);

        return "index";

    }

}
