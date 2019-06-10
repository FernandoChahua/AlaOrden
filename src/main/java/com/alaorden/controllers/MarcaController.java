package com.alaorden.controllers;
import com.alaorden.model.Marca;
import com.alaorden.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService){
        this.marcaService = marcaService;
    }
    @RequestMapping
    List<Marca> ListMarca(){
        List<Marca> lst  = new ArrayList<>();

        Marca marca = new Marca();
        marca.idMarca = 1;
        marca.nombre = "funciona pe";
        lst.add(marca);
        return lst;
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Marca FindById(@PathVariable int id){
        return marcaService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Marca createMarca(@RequestBody Marca entity){
        return null;
    }

}
