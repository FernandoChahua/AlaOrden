package com.alaorden.controllers;
import com.alaorden.model.Franquicia;
import com.alaorden.service.ServiceFranquicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {
    ServiceFranquicia serviceFranquicia;

    @Autowired
    public FranquiciaController(ServiceFranquicia serviceFranquicia){
        this.serviceFranquicia = serviceFranquicia;
    }
    @RequestMapping
    List<Franquicia> ListFranquicia(){
        return serviceFranquicia.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Franquicia FindById(@PathVariable int id){
        return serviceFranquicia.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Franquicia createFranquicia(@RequestBody Franquicia entity){
        return null;
    }

}
