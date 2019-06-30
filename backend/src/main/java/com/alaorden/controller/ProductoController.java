package com.alaorden.controller;

import com.alaorden.model.Category;
import com.alaorden.model.Brand;
import com.alaorden.model.Product;
import com.alaorden.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


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

    @RequestMapping(path="/ById/{id}",method= RequestMethod.GET)
    List<Product> getProductos(@PathVariable int id){
        return productService.listProductsByCategory(id);
    }
    @RequestMapping(value="/ByName/{name}",method= RequestMethod.GET)
    public  List<Product> getProductosName(@PathVariable("name") String name){
        if(name.equals("*")){
            name = "";
        }
        return productService.listProductSearch(name);
    }
}

