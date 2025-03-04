package com.recar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * @author fonse
 */
@Entity
@Data
@Table(name = "auto")
public class Auto {

     @Id
    private int id;

    @Column(name = "no_inv")
    @NotEmpty(message = "El número de inventario no puede estar vacío")
    private String no_inv;

    @Column(name = "submarca")
    @NotEmpty(message = "La submarca no puede estar vacía")
    private String submarca;

    @Column(name = "transm")
    @NotEmpty(message = "El tipo de transmisión no puede estar vacío")
    private String transm;

    @Column(name = "modelo")
    private int modelo;

    @Column(name = "color")
    @NotEmpty(message = "El color no puede estar vacío")
    private String color;

    @Column(name = "km")
    private Integer km;

    @Column(name = "serie")
    @NotEmpty(message = "El número de serie no puede estar vacío")
    private String serie;

    @Column(name = "estatus")
    @NotEmpty(message = "El estatus no puede estar vacío")
    private String estatus;

    @Column(name = "precio")
    private double precio;

    @Column(name = "ubicacion")
    @NotEmpty(message = "La ubicación no puede estar vacía")
    private String ubicacion;

    @Column(name = "descripcion")
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now(); // Fecha de registro al momento de la creación

    // Relación OneToMany con AutoImage
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_id")
    @JsonIgnore // Evitar que las imágenes se incluyan en la respuesta JSON
    private List<AutoImage> imagenes;

    // Método que devuelve las URLs completas de las imágenes
    public List<String> getImagenesUrls() {
        return imagenes.stream()
                       .map(image -> "http://localhost:8080/images/" + image.getName()) // Construye la URL completa para cada imagen
                       .collect(Collectors.toList());
    }

}
