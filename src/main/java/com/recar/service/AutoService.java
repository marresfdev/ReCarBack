package com.recar.service;

import com.recar.entity.Auto;
import com.recar.repository.AutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fonse
 */
@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> obtenerAutos() {
        return autoRepository.findAll();
    }

    public List<Auto> obtenerTodosLosAutos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
