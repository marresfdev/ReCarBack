/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.service;

import com.recar.dto.RegisterRequest;
import com.recar.entity.Authority;
import com.recar.entity.User;
import com.recar.repository.AuthorityRepository;
import com.recar.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author fonse
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequest request) {
    if (userRepository.findByCorreo(request.getCorreo()).isPresent()) {
        throw new RuntimeException("El correo ya está registrado.");
    }

    // Crear usuario sin guardar aún
    User user = new User();
    user.setUsername(request.getUsername());
    user.setCorreo(request.getCorreo());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setEnabled(true);

    // Guardar usuario primero
    final User savedUser = userRepository.save(user);  // Se usa 'final' aquí

    // Asignar roles sin duplicarlos
    Set<Authority> authorities = request.getRoles().stream()
        .map(role -> authorityRepository.findByAuthorityAndUser(role, savedUser)
            .orElseGet(() -> {
                Authority newAuthority = new Authority();
                newAuthority.setAuthority(role);
                newAuthority.setUser(savedUser);
                return authorityRepository.save(newAuthority);
            })
        )
        .collect(Collectors.toSet());

    savedUser.setAuthorities(authorities);
    return userRepository.save(savedUser);
}

}
