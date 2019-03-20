/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.service;

import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.repository.usuarioRepository;
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
public class usuarioService {
    @Autowired
    usuarioRepository usuarioRepository;
    
    public Usuario Safe(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> List(){
        return usuarioRepository.findAll();
    }
    
    public List<Usuario> findByUsernameAndEmail(String username, String email) {
        return this.usuarioRepository.findAllByUsernameOrUsuarioEmail(username, email);
    }
}
