package com.recar.controller;

import com.recar.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    private final String correoDestino = "gte.ventas@recarmotors.com";

    @GetMapping("/email")
    public String enviarCorreo(@RequestParam String asunto, @RequestParam String mensaje) {
        emailService.enviarCorreo(correoDestino, asunto, mensaje);
        return "Correo enviado a: " + correoDestino;
    }
}
