package com.recar.controller;

import com.recar.entity.Auto;
import com.recar.repository.AutoRepository;
import com.recar.service.AutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api")
public class AutoController {
    @Autowired
    AutoRepository autoRepository;

    @GetMapping("/getAllAutos")
    public List<Auto> getAllAutos(){
        return autoRepository.findAll();
    }

}
