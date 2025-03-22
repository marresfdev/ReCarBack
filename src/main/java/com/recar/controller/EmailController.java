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
    public ResponseEntity<Map<String, String>> enviarCorreo(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        String email = requestBody.get("email");
        String message = requestBody.get("message");

        String asunto = "Página Web ReCarMotors - Apartado de Contáctanos";
        String mensaje = "Nombre de cliente: " + name + "\nContacto: " + email + "\nMensaje: " + message;

        emailService.enviarCorreo(correoDestino, asunto, mensaje);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Correo enviado");
        return ResponseEntity.ok().body(response);
    }
    
    //ES ESTA LA FUNCIÓN QUE SE DEBE MODIFICAR
    @PostMapping("/emailBuro")
    public ResponseEntity<Map<String, String>> enviarCorreoBuro(
            @RequestParam("contacto") String contacto,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            String asunto = "Página Web ReCarMotors - Revisión de Buró de Crédito";
            String mensaje = "Contacto de cliente: " + contacto;

            emailService.enviarCorreoConImagen(correoDestino, asunto, mensaje, imagen);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Correo enviado");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error al enviar el correo: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
