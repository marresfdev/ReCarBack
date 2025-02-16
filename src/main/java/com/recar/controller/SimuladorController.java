/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.controller;

import java.time.LocalDateTime;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping("/calcularCredito")
    public Float enviarCorreoFunc(@RequestParam("precio") int precio, @RequestParam("enganche") int enganche,
            @RequestParam("plazo") int plazo, @RequestParam("tasa") float tasa, Model model) {
        
        float montoPrestamo = precio - enganche;
        float tasaMensual = (tasa / 100) / 12;
        
        if (tasaMensual == 0) {
        return montoPrestamo / plazo;
        }
        
        float mensualidad = (montoPrestamo * tasaMensual) / (1 - (float) Math.pow(1 + tasaMensual, -plazo));

        return mensualidad;
    }

    
    
    
}
