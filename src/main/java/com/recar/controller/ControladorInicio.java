/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

package com.recar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author fonse
 */
@Controller
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String page(Model model) {
        System.out.println("ESTA ES LA PANTALLA DE INICIO");
        return "index";
    }

}
