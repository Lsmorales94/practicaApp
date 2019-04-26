/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author britney guzman
 */

@Entity
@Table(name="tareas")
public class Tareas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Tareas")
    private Integer id;

    @Column(name = "tareas_fecha")
    private Date tareasFecha;
    
    @Column(name = "tareas_descripcion")
    private String tareasDescripcion;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "usuarios_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;
        
    @Column(name = "deleted_at")
    private Integer deletedAt = 0;

    public Tareas() {
    }

    public Tareas(Integer id, Date tareasFecha, String tareasDescripcion, Usuario usuario) {
        this.id = id;
        this.tareasFecha = tareasFecha;
        this.tareasDescripcion = tareasDescripcion;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTareasFecha() {
        return tareasFecha;
    }

    public void setTareasFecha(Date tareasFecha) {
        this.tareasFecha = tareasFecha;
    }

    public String getTareasDescripcion() {
        return tareasDescripcion;
    }

    public void setTareasDescripcion(String tareasDescripcion) {
        this.tareasDescripcion = tareasDescripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Integer deletedAt) {
        this.deletedAt = deletedAt;
    }
    
}
