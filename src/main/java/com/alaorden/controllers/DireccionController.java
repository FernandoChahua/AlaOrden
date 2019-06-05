package com.alaorden.controllers;
import com.alaorden.model.Direccion;
import com.alaorden.service.ServiceDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    ServiceDireccion serviceDireccion;

    @Autowired
    public DireccionController(ServiceDireccion serviceDireccion){
        this.serviceDireccion = serviceDireccion;
    }
    @RequestMapping
    List<Direccion> ListDireccion(){
        return serviceDireccion.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Direccion FindById(@PathVariable int id){
        return serviceDireccion.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Direccion createDireccion(@RequestBody Direccion entity){
        return null;
    }

}
