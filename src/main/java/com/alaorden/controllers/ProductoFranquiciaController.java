package com.alaorden.controllers;
import com.alaorden.model.ProductoFranquicia;
import com.alaorden.service.ServiceProductoFranquicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productosfranquicias")
public class ProductoFranquiciaController {
    ServiceProductoFranquicia serviceProductoFranquicia;

    @Autowired
    public ProductoFranquiciaController(ServiceProductoFranquicia serviceProductoFranquicia){
        this.serviceProductoFranquicia = serviceProductoFranquicia;
    }
    @RequestMapping
    List<ProductoFranquicia> ListProductoFranquicia(){
        return serviceProductoFranquicia.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    ProductoFranquicia FindById(@PathVariable int id){
        return serviceProductoFranquicia.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    ProductoFranquicia createProductoFranquicia(@RequestBody ProductoFranquicia entity){
        return null;
    }

}
