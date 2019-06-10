package com.alaorden.controllers;
import com.alaorden.model.Direccion;
import com.alaorden.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    DireccionService direccionService;

    @Autowired
    public DireccionController(DireccionService direccionService){
        this.direccionService = direccionService;
    }
    @RequestMapping
    List<Direccion> ListDireccion(){
        return direccionService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Direccion FindById(@PathVariable int id){
        return direccionService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Direccion createDireccion(@RequestBody Direccion entity){
        return null;
    }

}
