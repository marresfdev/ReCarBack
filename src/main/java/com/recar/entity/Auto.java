/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Entity
@Data
@Table(name = "auto")
public class Auto {

    @Id
    private int id;
    private String no_inv;
    private String submarca;
    private String transm;
    private int modelo;
    private String color;
    private Integer km;
    private String serie;
    private String estatus;
    private double precio;
    private String ubicacion;
    private String descripcion;
    private String imagen;
    private boolean activo;

    // Getters y setters
}
