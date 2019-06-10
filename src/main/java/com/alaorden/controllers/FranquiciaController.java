package com.alaorden.controllers;
import com.alaorden.model.Franquicia;
import com.alaorden.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {
    FranquiciaService franquiciaService;

    @Autowired
    public FranquiciaController(FranquiciaService franquiciaService){
        this.franquiciaService = franquiciaService;
    }
    @RequestMapping
    List<Franquicia> ListFranquicia(){
        return franquiciaService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Franquicia FindById(@PathVariable int id){
        return franquiciaService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Franquicia createFranquicia(@RequestBody Franquicia entity){
        return null;
    }

}
