package com.alaorden.controllers;

import com.alaorden.model.Category;
import com.alaorden.model.Brand;
import com.alaorden.model.Product;
import com.alaorden.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serv")
public class ProductoController {
    ProductService productService;
    @Autowired
    public ProductoController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(path="/productos",method= RequestMethod.GET)
    List<Product> getProductos(){
        return productService.listProducts();
    }
    @RequestMapping(path="/categorias",method= RequestMethod.GET)
    List<Category> getCategoria(){
        return productService.listCategories();
    }
    @RequestMapping(path="/marcas",method= RequestMethod.GET)
    List<Brand> getMarcas(){
        return productService.listBrand();
    }
}
