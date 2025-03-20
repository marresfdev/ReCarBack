package com.recar.repository;

import com.recar.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author fonse
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> { // 👈 Agrega JpaRepository
    Optional<User> findByCorreo(String correo);
}
