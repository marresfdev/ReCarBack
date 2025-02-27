/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fonse
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarCorreo(String correoDestino, String asunto, String mensaje) {
        SimpleMailMessage mensajeCorreo = new SimpleMailMessage();
        mensajeCorreo.setTo(correoDestino);
        mensajeCorreo.setSubject(asunto);
        mensajeCorreo.setText(mensaje);
        emailSender.send(mensajeCorreo);
    }
    
        public void enviarCorreoConImagen(String destinatario, String asunto, String mensaje, MultipartFile imagen) throws MessagingException, IOException {
        MimeMessage mensajeCorreo = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensajeCorreo, true); // `true` indica que soporta adjuntos

        helper.setTo(destinatario);
        helper.setSubject(asunto);
        helper.setText(mensaje, true); // `true` para HTML

        if (imagen != null && !imagen.isEmpty()) {
            InputStreamSource imageSource = new ByteArrayResource(imagen.getBytes());
            helper.addAttachment(imagen.getOriginalFilename(), imageSource);
        }

        emailSender.send(mensajeCorreo);
    }
}
