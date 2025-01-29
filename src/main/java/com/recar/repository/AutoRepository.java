/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.recar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recar.entity.Auto;
/**
 *
 * @author fonse
 */
public interface AutoRepository extends JpaRepository<Auto, String> {

}
