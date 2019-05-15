/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.pruebaUno.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * 
 * @author britney guzman
 */
@Entity
@Table (name="cigarrillos")
public class Cigarrillos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")        
    int id;
    
    @Column (name ="marca_cigarrillo")
    String marcaCigarrillo;
    
    @Column (name ="valor_cigarrillo")
    int valorCigarrillo;
    
    @Column (name = "cigarros_Diarios")
    int cigarrosDiarios;
    
    @Column (name = "tiempo_Consumo")
    int tiempoConsumo;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    
    @Column(name = "fecha_actual")
    private Date fechaFin;
//    
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "usuario_id", nullable = false)
//    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "usuarios_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;
        
    public Cigarrillos() {
    }
        
    public Cigarrillos(int id, String marcaCigarrillo, int valorCigarrillo, int cigarrosDiarios, int tiempoConsumo, Date fechaInicio, Date fechaFin, Usuario usuario) {
        this.id = id;
        this.marcaCigarrillo = marcaCigarrillo;
        this.valorCigarrillo = valorCigarrillo;
        this.cigarrosDiarios = cigarrosDiarios;
        this.tiempoConsumo = tiempoConsumo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarcaCigarrillo() {
        return marcaCigarrillo;
    }

    public void setMarcaCigarrillo(String marcaCigarrillo) {
        this.marcaCigarrillo = marcaCigarrillo;
    }

    public int getValorCigarrillo() {
        return valorCigarrillo;
    }

    public void setValorCigarrillo(int valorCigarrillo) {
        this.valorCigarrillo = valorCigarrillo;
    }

    public int getCigarrosDiarios() {
        return cigarrosDiarios;
    }

    public void setCigarrosDiarios(int cigarrosDiarios) {
        this.cigarrosDiarios = cigarrosDiarios;
    }

    public int getTiempoConsumo() {
        return tiempoConsumo;
    }

    public void setTiempoConsumo(int tiempoConsumo) {
        this.tiempoConsumo = tiempoConsumo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
