/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.security.Timestamp;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Entity
@Data
@Table(name = "simulador")
public class Simulador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal precioVehiculo;
    private BigDecimal enganche;
    private int plazo;
    private BigDecimal tasaInteres;
    private String resultado;
    private String modeloVehiculo;
    private String marcaVehiculo;
    private int anoVehiculo;
    private String buroCredito;
    private Timestamp fecha;

}
