package com.alaorden.controllers;

import com.alaorden.model.Categoria;
import com.alaorden.model.Marca;
import com.alaorden.model.Producto;
import com.alaorden.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serv")
public class ProductoController {
    ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @RequestMapping(path="/productos",method= RequestMethod.GET)
    List<Producto> getProductos(){
        return productoService.listProductos();
    }
    @RequestMapping(path="/categorias",method= RequestMethod.GET)
    List<Categoria> getCategoria(){
        return productoService.listCategorias();
    }
    @RequestMapping(path="/marcas",method= RequestMethod.GET)
    List<Marca> getMarcas(){
        return productoService.listMarca();
    }
}
