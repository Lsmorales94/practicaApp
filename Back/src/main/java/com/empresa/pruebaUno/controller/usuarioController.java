/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.controller;

import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.service.usuarioService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//

/**
 *
 * @author britney guzman
 */

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class usuarioController {
     
    @Autowired
    usuarioService usuarioService;
    
//    @CrossOrigin(origins="*")
//    @PostMapping(value="/registrar")
//    public ResponseEntity<Usuario> Save (@RequestBody Usuario usuario){
//         return new ResponseEntity<>(usuarioService.Safe(usuario), HttpStatus.OK);
//    }
    
    @CrossOrigin(origins="*")
    @GetMapping(value="/listar")
    public ResponseEntity<List<Usuario>> List (){        
        return new ResponseEntity<>(usuarioService.List(), HttpStatus.OK);
    }
    
    @CrossOrigin(origins="*")
    @PostMapping(value = "/registrar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario user){
       
        List<Usuario> users = this.usuarioService.findByUsernameAndEmail(user.getUsername(), user.getPassword());
            if(!users.isEmpty()){
               
                throw new EntityNotFoundException("El usuario se encuentra registrado");
            }
        return new ResponseEntity<>(usuarioService.Safe(user), HttpStatus.CREATED);    
    }
    
    
    @PostMapping(value = "/login/{username}/password/{password}")
    public ResponseEntity<Usuario> login(@Valid @PathVariable String username,@Valid @PathVariable String password){
       
        
        Usuario user = this.usuarioService.findByUsernameAndPassword(username, password);
            if(user == null){
                throw new EntityNotFoundException("El usuario no se encuentra registrado");
            }
        return new ResponseEntity<>(user, HttpStatus.OK);    
    }
    
    
//    @CrossOrigin(origins="*")
//    @RequestMapping("/login")
//    public boolean login(@RequestBody Usuario user) {
//        return
//          user.getUsername().equals("user") && user.getPassword().equals("password");
//    }
//     
//    @CrossOrigin(origins="*")
//    @RequestMapping("/user")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization")
//          .substring("Basic".length()).trim();
//        return () ->  new String(Base64.getDecoder()
//          .decode(authToken)).split(":")[0];
//    }
    
}
