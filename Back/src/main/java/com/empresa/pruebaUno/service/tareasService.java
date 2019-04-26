/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.service;

import com.empresa.pruebaUno.entity.Tareas;
import com.empresa.pruebaUno.repository.tareasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author britney guzman
 */
@Service
@Transactional
public class tareasService {
    
     @Autowired
    tareasRepository tareasRepository;
    
    public Tareas Save(Tareas tarea){
        return tareasRepository.save(tarea);
    }

   public List<Tareas> List(){
       return tareasRepository.findAll();
   }
}
