/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.controller;

import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.service.usuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britney guzman
 */
@RestController
@RequestMapping("/usuario")
public class usuarioController {
     
    @Autowired
    usuarioService usuarioService;
    
    @CrossOrigin(origins="*")
    @PostMapping(value="/registrar")
    public ResponseEntity<Usuario> Safe (@RequestBody Usuario usuario){
         return new ResponseEntity<>(usuarioService.Safe(usuario), HttpStatus.OK);
    }
    
    @CrossOrigin(origins="*")
    @GetMapping(value="/listar")
    public ResponseEntity<List<Usuario>> List (){
        
        return new ResponseEntity<>(usuarioService.List(), HttpStatus.OK);
    }
    
    
    
}
