package com.recar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fonse
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir solicitudes desde http://localhost:5173
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Asegúrate de que esta URL coincida con tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Los métodos HTTP que deseas permitir
                .allowedHeaders("*") // Permitir todos los encabezados
                .allowCredentials(true); // Si necesitas enviar cookies o credenciales
    }
}
