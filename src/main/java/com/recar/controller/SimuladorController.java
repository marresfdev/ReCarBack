/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.controller;

import com.recar.entity.Auto;
import com.recar.repository.AutoRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fonse
 */
@RestController
@RequestMapping("/api")
public class SimuladorController {
    @Autowired
    private AutoRepository repo;
    
    @PostMapping("/calcularCredito")
    public Double calcularCredito(@RequestBody CreditRequest creditRequest) {
        //QUE SE MANDE EL ID DE LA UNIDAD Y QUE EN BASE A ESO SE BUSQUE EL PRECIO DE ESTA
        //auto.getId();
        //Auto autoExis = repo.findById(autoExis.getAuto());
        int id = creditRequest.getId();
        int enganche = creditRequest.getEnganche();
        double plazo = creditRequest.getPlazo();
        float tasa = creditRequest.getTasa();
        
        Optional<Auto> newAuto = repo.findById(id);
        Auto autoEncontrado = newAuto.orElse(null);
        if (autoEncontrado == null) {
            throw new IllegalArgumentException("Auto no encontrado con ID: " + id);
        }
        double precio = autoEncontrado.getPrecio();
        
        // Validaciones para asegurarse de que los valores no sean negativos
        if (precio <= 0 || enganche < 0 || plazo <= 0 || tasa < 0) {
            throw new IllegalArgumentException("Los valores de precio, enganche, plazo y tasa deben ser positivos.");
        }

        double montoPrestamo = precio - enganche;
        double tasaMensual = (tasa / 100) / 12;

        // Si la tasa es 0, el cálculo es simple
        if (tasaMensual == 0) {
            return montoPrestamo / plazo;
        }

        // Si el plazo es 0, evitar la división por 0
        if (plazo <= 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor que 0.");
        }

        // Cálculo de la mensualidad
        double mensualidad = (montoPrestamo * tasaMensual) / (1 - (float) Math.pow(1 + tasaMensual, -plazo));

        return mensualidad;
    }
    
    static class CreditRequest {
        private int id;
        private int precio;
        private int enganche;
        private int plazo;
        private float tasa;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // Getters and setters
        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public int getEnganche() {
            return enganche;
        }

        public void setEnganche(int enganche) {
            this.enganche = enganche;
        }

        public int getPlazo() {
            return plazo;
        }

        public void setPlazo(int plazo) {
            this.plazo = plazo;
        }

        public float getTasa() {
            return tasa;
        }

        public void setTasa(float tasa) {
            this.tasa = tasa;
        }
    }
}