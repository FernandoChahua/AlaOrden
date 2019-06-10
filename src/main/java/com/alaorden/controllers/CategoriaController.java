package com.alaorden.controllers;
import com.alaorden.model.Categoria;
import com.alaorden.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    @RequestMapping
    List<Categoria> ListCategoria(){
        return categoriaService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Categoria FindById(@PathVariable int id){
        return categoriaService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Categoria createCategoria(@RequestBody Categoria entity){
        return null;
    }

}
