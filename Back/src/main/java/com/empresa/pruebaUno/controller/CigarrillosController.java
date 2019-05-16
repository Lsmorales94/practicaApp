/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.controller;

import com.empresa.pruebaUno.Exception.FailCreateException;
import com.empresa.pruebaUno.common.Menssage;
import com.empresa.pruebaUno.entity.Cigarrillos;
import com.empresa.pruebaUno.entity.Tareas;
import com.empresa.pruebaUno.entity.Usuario;
import com.empresa.pruebaUno.repository.CigarrillosRepository;
import com.empresa.pruebaUno.repository.UsuarioRepository;
import com.empresa.pruebaUno.service.CigarrillosService;
import com.empresa.pruebaUno.service.UsuarioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author britney guzman
 */
@RestController
@CrossOrigin
@RequestMapping("/cigarrillos")
public class CigarrillosController {
    
    @Autowired
    CigarrillosService cigarrillosService;
    
    @Autowired
    CigarrillosRepository cigarrillosRepository;
       
    @Autowired
    UsuarioRepository usuarioRepository;  
    
    @Autowired
    UsuarioService usuarioService;
    
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Cigarrillos>> List() {
        return new ResponseEntity<>(cigarrillosService.List(), HttpStatus.OK);
    }
    
   //Agregar información de cigarrrillos a un usuario Registrado
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/usuario/{usuario_id}/agregarConsumo")
    public ResponseEntity<Cigarrillos> agregarTarea(@Valid @PathVariable Integer usuario_id,
                               @Valid @RequestBody Cigarrillos cigarrillo) {
          return usuarioRepository.findById(usuario_id)
                  .map(usuario -> {
                      cigarrillo.setUsuario(usuario);
                      cigarrillo.setFechaFin(Date.from(Instant.now()));
                      cigarrillo.setFechaInicio(Date.from(Instant.now()));
                      return new ResponseEntity<>(cigarrillosRepository.save(cigarrillo), HttpStatus.CREATED);                      
                  }).orElseThrow(() -> new FailCreateException("No se pudo actualizar el usuario con id "+usuario_id));      
    }
    
      //Actualiza información del consumo de cigarrillos 
    @PutMapping("/usuarioId/{usuario_id}/cigarrilloId/{cigarrilloId}/actualizarConsumo")
    public ResponseEntity<Cigarrillos> updateCigarrillo(@PathVariable Integer usuario_id,
    						   @PathVariable Integer cigarrilloId,
    						   @Valid @RequestBody Cigarrillos cigarrillosUpdated) {
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);
        if (user.isPresent()) {
            
            return cigarrillosRepository.findById(cigarrilloId)
                .map(cigarrillo -> {
                    cigarrillo.setCigarrosDiarios(cigarrillosUpdated.getCigarrosDiarios());
                   // cigarrillo.setFechaInicio(Date.from(Instant.now()));
                    cigarrillo.setFechaFin(Date.from(Instant.now()));
                    cigarrillo.setMarcaCigarrillo(cigarrillosUpdated.getMarcaCigarrillo());
                    cigarrillo.setTiempoConsumo(cigarrillosUpdated.getTiempoConsumo());
                    cigarrillo.setValorCigarrillo(cigarrillosUpdated.getValorCigarrillo());
                     return new ResponseEntity<>(cigarrillosRepository.save(cigarrillo), HttpStatus.CREATED);
                }).orElseThrow(() -> new EntityNotFoundException("No se pudo encontrar la información de consumo "+cigarrilloId));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
    }
    
     //Borra Tarea
    @DeleteMapping("/usuarioId/{usuarioId}/cigarrilloId/{cigariiloId}")
    public ResponseEntity<Menssage> deleteTarea(@PathVariable Integer usuarioId,
    						@PathVariable Integer cigarrilloId) {
    	
    	Optional<Usuario> user = this.usuarioService.findOne(usuarioId);
        if (user.isPresent()) {
    	
            return cigarrillosRepository.findById(cigarrilloId)
                    .map(cigarrillo -> {
                        cigarrillosRepository.delete(cigarrillo);
                        return new ResponseEntity<Menssage>(new Menssage("Información de consumo eliminada "),HttpStatus.ACCEPTED);
                    }).orElseThrow(() -> new EntityNotFoundException("Información no encontrada !"));
        }else 
            throw new EntityNotFoundException("No se pudo obtener el usuario id "+usuarioId);
    }
    
    
     //Información de consumo de un usuario
//    @GetMapping("/usuario/{usuario_id}/informacionCigarrillo")
//    public ResponseEntity <Cigarrillos> findByUsuarioId (@Valid @PathVariable Integer usuario_id){
//    
//        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);
//
//        if (!user.isPresent()) {
//            throw new EntityNotFoundException("No se pudo obtener el usuario ");
//        }   	
//        Cigarrillos cig = cigarrillosService.findByUsuarioId(usuario_id);
//        if(cig == null){
//           throw new EntityNotFoundException("No se regisra información del consumo ");
//        }
//        return new ResponseEntity<>( cigarrillosService.findByUsuarioId(usuario_id), HttpStatus.OK);   
//    }
//    
    @GetMapping("/valor/{usuario_id}")
    public int valor(@Valid @PathVariable Integer usuario_id) {
        int dias = 0;
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);
        if (user.isPresent()) {
            List<Cigarrillos> cig =  cigarrillosService.findByUsuarioId(usuario_id);
            if (cig.isEmpty()) {
                return dias;
            }else{
                Date fechaInicio = cig.get(0).getFechaInicio();
                Date fechaActual = cig.get(0).getFechaFin();
    ;

                dias = (int) ((fechaActual.getTime() - fechaInicio.getTime()) / 86400000);

                System.out.println("Hay " + dias + " dias de diferencia");
            }
        }else{
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }
        return dias;
    }
    
 
    
    @GetMapping("/usuario/{usuario_id}/informacionCigarrillo")
    public ResponseEntity<List<Cigarrillos>> listarConsumobyUsuarioId (@Valid @PathVariable Integer usuario_id){
    
        Optional<Usuario> user = this.usuarioService.findOne(usuario_id);

        if (!user.isPresent()) {
            throw new EntityNotFoundException("No se pudo obtener el usuario ");
        }   	
        return new ResponseEntity<>( cigarrillosService.findByUsuarioId(usuario_id), HttpStatus.OK);   
    }
}


