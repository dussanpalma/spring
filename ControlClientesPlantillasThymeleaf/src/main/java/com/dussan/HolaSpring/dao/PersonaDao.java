package com.dussan.HolaSpring.dao;

import com.dussan.HolaSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface PersonaDao extends CrudRepository<Persona, Long>{
    
    
    
}
