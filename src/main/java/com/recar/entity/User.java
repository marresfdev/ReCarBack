/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.recar.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;
import lombok.Data;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 *
 * @author fonse
 */
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private String correo; // Ahora el ID es el correo

    private String username;
    private boolean enabled;
    private String password;
    private String token;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authority> authorities;

    @Override
    public int hashCode() {
        return Objects.hash(correo); // Usar correo como identificador
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(correo, user.correo);
    }
}

