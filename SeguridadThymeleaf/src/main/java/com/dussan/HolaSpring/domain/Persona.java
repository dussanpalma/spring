package com.dussan.HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;



@Data
@Entity //JPA HIBERNATE
@Table(name = "persona")

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //para los tipo ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty  //PARA QUE NUNCA ESTE VACIO, AL HACER LA VALIDACION 
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    
    private String telefono;

}
