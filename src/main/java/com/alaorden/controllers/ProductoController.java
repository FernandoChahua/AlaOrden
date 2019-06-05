package com.alaorden.controllers;
import com.alaorden.model.Producto;
import com.alaorden.service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    ServiceProducto serviceProducto;

    @Autowired
    public ProductoController(ServiceProducto serviceProducto){
        this.serviceProducto = serviceProducto;
    }
    @RequestMapping
    List<Producto> ListProducto(){
        return serviceProducto.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Producto FindById(@PathVariable int id){
        return serviceProducto.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Producto createProducto(@RequestBody Producto entity){
        return null;
    }

}
