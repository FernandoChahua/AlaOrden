package com.alaorden.controllers;
import com.alaorden.model.Transaccion;
import com.alaorden.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService){
        this.transaccionService = transaccionService;
    }
    @RequestMapping
    List<Transaccion> ListTransaccion(){
        return transaccionService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Transaccion FindById(@PathVariable int id){
        return transaccionService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Transaccion createTransaccion(@RequestBody Transaccion entity){
        return null;
    }

}
