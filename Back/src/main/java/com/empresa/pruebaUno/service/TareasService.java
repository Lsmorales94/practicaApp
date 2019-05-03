/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.service;

import com.empresa.pruebaUno.entity.Tareas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.empresa.pruebaUno.repository.TareasRepository;

/**
 *
 * @author britney guzman
 */
@Service
@Transactional
public class TareasService {
    
     @Autowired
    TareasRepository tareasRepository;
    
    public Tareas Save(Tareas tarea){
        return tareasRepository.save(tarea);
    }

   public List<Tareas> List(){
       return tareasRepository.findAll();
   }
}
