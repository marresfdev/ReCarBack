package com.recar.controller;

import com.recar.service.EmailService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:5174") //problemas de cors
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    //private final String correoDestino = "gte.ventas@recarmotors.com";
    
    //correo de pruebas
    private final String correoDestino = "2021371037@uteq.edu.mx";

    @PostMapping("/email")
    public ResponseEntity<Map<String, String>> enviarCorreo(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        String asunto = "Página Web ReCarMotors";
        String mensaje = "Cliente: "+ name + "\nContacto: "+ email+ "\nMensaje: "+ message;
        emailService.enviarCorreo(correoDestino, asunto, mensaje);
        //return "Correo enviado a: " + correoDestino;
        
        // Usamos un HashMap para la respuesta
        Map<String, String> response = new HashMap<>();
        response.put("message", "Correo enviado a: " + correoDestino);
        return ResponseEntity.ok().body(response);
    }
    
    //ES ESTA LA FUNCIÓN QUE SE DEBE MODIFICAR
    @PostMapping("/emailBuro")
    public ResponseEntity<Map<String, String>> enviarCorreoBuro(
            @RequestParam("contacto") String contacto,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            String asunto = "Página Web ReCarMotors";
            String mensaje = "Cliente: " + contacto;

            emailService.enviarCorreoConImagen(correoDestino, asunto, mensaje, imagen);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Correo enviado a: " + correoDestino);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error al enviar el correo: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
