package com.empresa.pruebaUno.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author britney guzman
 */
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")        
    int id;
    
    @Column (name ="usuario_nombre")
    String usuarioNombre;
    
    @Column (name ="usuario_apellido")
    String usuarioApellido;
    
    @Column (name = "usuario_telefono")
    String usuarioTelefono;
    
    @Column (name = "usuario_email")
    String usuarioEmail;
    
    @Column(name = "usuario_password")
    private String password;
    
    @Column(name = "deleted_at")
    private Integer deletedAt = 0;
    
    @OneToMany(mappedBy = "usuario", 
            cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY )
    private Set<Tareas> tareas;
    
    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "usuario")
    private Set<Cigarrillos> cigarrillos;

    public Usuario() {
    }

    public Usuario(int id, String usuarioNombre, String usuarioApellido, String usuarioTelefono, String usuarioEmail, String password, Set<Tareas> tareas, Set<Cigarrillos> cigarrillos) {
        this.id = id;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioTelefono = usuarioTelefono;
        this.usuarioEmail = usuarioEmail;
        this.password = password;
        this.tareas = tareas;
        this.cigarrillos = cigarrillos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public String getUsuarioTelefono() {
        return usuarioTelefono;
    }

    public void setUsuarioTelefono(String usuarioTelefono) {
        this.usuarioTelefono = usuarioTelefono;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Integer deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Set<Tareas> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tareas> tareas) {
        this.tareas = tareas;
    }

    public Set<Cigarrillos> getCigarrillos() {
        return cigarrillos;
    }

    public void setCigarrillos(Set<Cigarrillos> cigarrillos) {
        this.cigarrillos = cigarrillos;
    }
  
    

}