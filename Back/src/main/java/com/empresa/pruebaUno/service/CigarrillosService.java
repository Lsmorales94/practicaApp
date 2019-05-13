/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.service;

import com.empresa.pruebaUno.entity.Cigarrillos;
import com.empresa.pruebaUno.repository.CigarrillosRepository;
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
public class CigarrillosService {
    
    @Autowired
    CigarrillosRepository cigarrillosRepository;
    
    public List<Cigarrillos> List(){
      return cigarrillosRepository.findAll();
    }
    
    public List<Cigarrillos> findByUsuarioId(Integer usuario_id){
        return cigarrillosRepository.findByUsuarioId(usuario_id);    
    }
}
