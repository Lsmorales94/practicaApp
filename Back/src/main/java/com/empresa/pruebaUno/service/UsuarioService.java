/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.service;

import com.empresa.pruebaUno.entity.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.empresa.pruebaUno.repository.UsuarioRepository;

/**
 *
 * @author britney guzman
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Usuario Save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> List(){
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> findOne(Integer id){
        return this.usuarioRepository.findById(id);
    }
    
    public Usuario findByusuarioEmail(String email) {
        return this.usuarioRepository.findByusuarioEmail(email);
    }
    
    public Usuario findByusuarioEmailAndPassword(String usuarioEmail, String password){
        return usuarioRepository.findByusuarioEmailAndPassword(usuarioEmail, password);
    }
    
}
