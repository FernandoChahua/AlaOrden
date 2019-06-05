package com.alaorden.controllers;
import com.alaorden.model.Transaccion;
import com.alaorden.service.ServiceTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    ServiceTransaccion serviceTransaccion;

    @Autowired
    public TransaccionController(ServiceTransaccion serviceTransaccion){
        this.serviceTransaccion = serviceTransaccion;
    }
    @RequestMapping
    List<Transaccion> ListTransaccion(){
        return serviceTransaccion.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Transaccion FindById(@PathVariable int id){
        return serviceTransaccion.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Transaccion createTransaccion(@RequestBody Transaccion entity){
        return null;
    }

}
