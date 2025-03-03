/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.controller;

import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fonse
 */
@RestController
@RequestMapping("/api/images")
public class ImagesController {
    
     private static final String UPLOAD_DIR = "src/main/resources/static/img/";

    // Este método devuelve la imagen como recurso estático
    @GetMapping("/{filename}")
    public Resource getImage(@PathVariable String filename) throws Exception {
        try {
            return new UrlResource(Paths.get(UPLOAD_DIR + filename).toUri());
        } catch (Exception e) {
            throw new Exception("No se pudo cargar la imagen: " + filename, e);
        }
    }
    
}
