package com.empresa.pruebaUno.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Usuario(int id, String usuarioNombre, String usuarioApellido, String usuarioTelefono, String usuarioEmail, int usuarioEdad, String username, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioTelefono = usuarioTelefono;
        this.usuarioEmail = usuarioEmail;
        this.password = password;
    }

    public Usuario(){
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

    


}