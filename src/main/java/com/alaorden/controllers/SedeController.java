package com.alaorden.controllers;
import com.alaorden.model.Sede;
import com.alaorden.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {
    SedeService sedeService;

    @Autowired
    public SedeController(SedeService sedeService){
        this.sedeService = sedeService;
    }
    @RequestMapping
    List<Sede> ListSede(){
        return sedeService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Sede FindById(@PathVariable int id){
        return sedeService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Sede createSede(@RequestBody Sede entity){
        return null;
    }

}
