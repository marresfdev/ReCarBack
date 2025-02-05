package com.recar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Entity
@Data
@Table(name = "auto_imagenes")
public class AutoImagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "auto_id")
    private int autoId;

    @Column(name = "url")
    @NotEmpty(message = "La URL de la imagen no puede estar vacía")
    private String url;

}
