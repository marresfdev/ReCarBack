/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.dto;

import java.util.Set;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Data
public class RegisterRequest {
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private Set<String> roles;  // Puede ser ["ROLE_USER", "ROLE_ADMIN"]
}
