package com.alaorden.controllers;
import com.alaorden.model.Carrito;
import com.alaorden.service.ServiceCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {
    ServiceCarrito serviceCarrito;

    @Autowired
    public CarritoController(ServiceCarrito serviceCarrito){
        this.serviceCarrito = serviceCarrito;
    }
    @RequestMapping
    List<Carrito> ListCarrito(){
        return serviceCarrito.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Carrito FindById(@PathVariable int id){
        return serviceCarrito.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Carrito createCarrito(@RequestBody Carrito entity){
        return null;
    }

}
