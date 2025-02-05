/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Data
public class AutoDTO {
    private int id;
    private String noInv;
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
    private LocalDateTime fechaRegistro;
    private List<String> imagenes;  

    // Getters y Setters

}
