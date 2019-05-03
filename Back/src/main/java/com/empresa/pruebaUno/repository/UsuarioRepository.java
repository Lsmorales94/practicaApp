/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.repository;


import com.empresa.pruebaUno.entity.Tareas;
import com.empresa.pruebaUno.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * nbn nb
 * @author britney guzman
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
       
       public Usuario findByusuarioEmail(String email);
       Usuario findByusuarioEmailAndPassword(String usuarioEmail, String password);

   

}
