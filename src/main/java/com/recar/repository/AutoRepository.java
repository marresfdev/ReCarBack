/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.recar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recar.entity.Auto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fonse
 */
@Repository
public interface AutoRepository extends JpaRepository<Auto, String> {
    // Filtra autos con estatus 'Disponible'
    List<Auto> findByEstatus(String estatus);
    Optional<Auto> findById(int id);
    @Query("SELECT a FROM Auto a LEFT JOIN FETCH a.imagenes WHERE a.id = :id")
    Optional<Auto> findAutoWithImages(@Param("id") String id);
}
