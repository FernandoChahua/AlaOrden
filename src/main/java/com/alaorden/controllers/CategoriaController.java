package com.alaorden.controllers;
import com.alaorden.model.Categoria;
import com.alaorden.service.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    ServiceCategoria serviceCategoria;

    @Autowired
    public CategoriaController(ServiceCategoria serviceCategoria){
        this.serviceCategoria = serviceCategoria;
    }
    @RequestMapping
    List<Categoria> ListCategoria(){
        return serviceCategoria.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Categoria FindById(@PathVariable int id){
        return serviceCategoria.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Categoria createCategoria(@RequestBody Categoria entity){
        return null;
    }

}
