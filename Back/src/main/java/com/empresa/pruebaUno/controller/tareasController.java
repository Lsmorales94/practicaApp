/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.controller;

import com.empresa.pruebaUno.Exception.FailCreateException;
import com.empresa.pruebaUno.common.Menssage;
import com.empresa.pruebaUno.entity.Tareas;
import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.repository.tareasRepository;
import com.empresa.pruebaUno.repository.usuarioRepository;
import com.empresa.pruebaUno.service.tareasService;
import com.empresa.pruebaUno.service.usuarioService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author britney guzman
 */
@Controller
@CrossOrigin
@RequestMapping("/tareas")
public class tareasController {
    
    @Autowired 
    tareasService tareasService;
    
    @Autowired 
    tareasRepository tareasRepository;    
    
    @Autowired
    usuarioRepository usuarioRepository;    
    
    @Autowired
    usuarioService usuarioService;
    
        
    //Agregar tarea a un usuario Registrado
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/usuario/{usuario_id}/agregartarea")
    public ResponseEntity<Tareas> agregarTarea(@Valid @PathVariable Integer usuario_id,
                               @Valid @RequestBody Tareas tarea) {
          return usuarioRepository.findById(usuario_id)
                  .map(usuario -> {
                      tarea.setUsuario(usuario);
                      return new ResponseEntity<>(tareasRepository.save(tarea), HttpStatus.CREATED);                      
                  }).orElseThrow(() -> new FailCreateException("No se pudo actualizar el usuario con id "+usuario_id));      
    }
    
    //lista las tareas de un usuario
    @GetMapping("/usuario/{usuario_id}/listartareas")
    public ResponseEntity<List<Tareas>> listarTareasbyUsuarioId (@Valid @PathVariable Integer usuario_id){
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);

        if (!user.isPresent()) {
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }   	
        return new ResponseEntity<>( tareasRepository.findByUsuarioId(usuario_id), HttpStatus.OK);   
    }
    
    //Actualiza Tarea
    @PutMapping("/usuarioId/{usuario_id}/tareaId/{tarea_Id}")
    public ResponseEntity<Tareas> updateTarea(@PathVariable Integer usuario_id,
    						   @PathVariable Integer tarea_Id,
    						   @Valid @RequestBody Tareas tareasUpdated) {
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);
        if (user.isPresent()) {
            
            return tareasRepository.findById(tarea_Id)
                .map(tarea -> {
                    tarea.setTareasDescripcion(tareasUpdated.getTareasDescripcion());
                    tarea.setTareasFecha(tareasUpdated.getTareasFecha());
                    tarea.setDeletedAt(0);
                     return new ResponseEntity<>(tareasRepository.save(tarea), HttpStatus.ACCEPTED); 
                }).orElseThrow(() -> new EntityNotFoundException("No se pudo enconrar la Tarea "+tarea_Id));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
    }
    
    //Borra Tarea
    @DeleteMapping("/usuarioId/{usuarioId}/tareaId/{tareaId}")
    public ResponseEntity<Menssage> deleteAssignment(@PathVariable Integer usuarioId,
    							   @PathVariable Integer tareaId) {
    	
    	Optional<Usuario> user = this.usuarioService.findOne(usuarioId);
        if (user.isPresent()) {
    	
            return tareasRepository.findById(tareaId)
                    .map(tarea -> {
                        tareasRepository.delete(tarea);
                        return new ResponseEntity<Menssage>(new Menssage("eliminada"),HttpStatus.ACCEPTED);
                    }).orElseThrow(() -> new EntityNotFoundException("Tarea no encontrada !"));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario id "+usuarioId);
    }
}
