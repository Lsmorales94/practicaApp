/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.repository;


import com.empresa.pruebaUno.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * nbn nb
 * @author britney guzman
 */
@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Integer> {
     
}
