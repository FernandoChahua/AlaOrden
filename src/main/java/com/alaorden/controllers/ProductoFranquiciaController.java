package com.alaorden.controllers;
import com.alaorden.model.ProductoFranquicia;
import com.alaorden.service.ProductoFranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productosfranquicias")
public class ProductoFranquiciaController {
    ProductoFranquiciaService productoFranquiciaService;

    @Autowired
    public ProductoFranquiciaController(ProductoFranquiciaService productoFranquiciaService){
        this.productoFranquiciaService = productoFranquiciaService;
    }
    @RequestMapping
    List<ProductoFranquicia> ListProductoFranquicia(){
        return productoFranquiciaService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    ProductoFranquicia FindById(@PathVariable int id){
        return productoFranquiciaService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    ProductoFranquicia createProductoFranquicia(@RequestBody ProductoFranquicia entity){
        return null;
    }

}
