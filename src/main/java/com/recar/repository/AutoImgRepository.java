/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.recar.repository;

import com.recar.entity.AutoImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fonse
 */
public interface AutoImgRepository extends JpaRepository<AutoImage, Long>{
        List<AutoImage> findByAutoId(Long autoId);  // Obtener imágenes asociadas con un auto_id
    
}
