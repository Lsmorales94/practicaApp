/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.controller;

import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.service.usuarioService;
import java.util.List;
import java.util.Optional;
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

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/registrar")
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario user) {

        Usuario usr = this.usuarioService.findByusuarioEmail(user.getUsuarioEmail());
        if (usr != null) {

            throw new EntityNotFoundException("El usuario se encuentra registrado");
        }
        return new ResponseEntity<>(usuarioService.Save(user), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/login/email/{usuarioEmail}/password/{password}")
    public ResponseEntity<Usuario> login(@Valid @PathVariable String usuarioEmail, @Valid @PathVariable String password) {

        Usuario user = this.usuarioService.findByusuarioEmailAndPassword(usuarioEmail, password);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Usuario>> List() {
        return new ResponseEntity<>(usuarioService.List(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findOne(@Valid @PathVariable Integer id) {

        Optional<Usuario> user = this.usuarioService.findOne(id);

        if (user == null) {
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }

        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }

}
