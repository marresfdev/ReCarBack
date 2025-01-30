/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.recar.repository;

import com.recar.entity.Simulador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fonse
 */
public interface SimuladorRepository extends JpaRepository <Simulador, String> {
    
}
