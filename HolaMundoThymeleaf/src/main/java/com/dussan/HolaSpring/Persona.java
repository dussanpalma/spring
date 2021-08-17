package com.dussan.HolaSpring;

import lombok.Data;


@Data //Esta anotación crea los get y setter, 
      //to string, has code, solo con la anotacion @Data del paquete lombok

public class Persona { 

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}

