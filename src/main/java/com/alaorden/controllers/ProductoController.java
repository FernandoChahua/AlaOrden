package com.alaorden.controllers;
import com.alaorden.model.Producto;
import com.alaorden.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }
    @RequestMapping
    List<Producto> ListProducto(){
        return productoService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Producto FindById(@PathVariable int id){
        return productoService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Producto createProducto(@RequestBody Producto entity){
        return null;
    }

}
