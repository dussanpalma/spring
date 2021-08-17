package com.dussan.HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity //JPA HIBERNATE
@Table(name = "persona")

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
