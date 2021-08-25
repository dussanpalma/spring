package com.dussan.HolaSpring.dao;

import com.dussan.HolaSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao  extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username); 
    
    
}
