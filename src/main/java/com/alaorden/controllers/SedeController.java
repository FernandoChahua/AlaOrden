package com.alaorden.controllers;
import com.alaorden.model.Sede;
import com.alaorden.service.ServiceSede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {
    ServiceSede serviceSede;

    @Autowired
    public SedeController(ServiceSede serviceSede){
        this.serviceSede = serviceSede;
    }
    @RequestMapping
    List<Sede> ListSede(){
        return serviceSede.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Sede FindById(@PathVariable int id){
        return serviceSede.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Sede createSede(@RequestBody Sede entity){
        return null;
    }

}
