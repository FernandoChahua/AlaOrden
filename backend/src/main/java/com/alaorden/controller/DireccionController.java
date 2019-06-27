package com.alaorden.controllers;


import com.alaorden.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    private DireccionService direccionService;
    @Autowired
    public DireccionController(DireccionService direccionService){
        this.direccionService = direccionService;
    }
}
