/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
}
