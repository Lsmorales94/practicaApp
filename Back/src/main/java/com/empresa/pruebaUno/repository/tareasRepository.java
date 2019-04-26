/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.repository;

import com.empresa.pruebaUno.entity.Tareas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author britney guzman
 */

@Repository
public interface tareasRepository extends JpaRepository<Tareas, Integer>{
    
    List<Tareas> findByUsuarioId(Integer usuarioId);
}
