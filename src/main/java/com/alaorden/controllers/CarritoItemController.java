package com.alaorden.controllers;
import com.alaorden.model.CarritoItem;
import com.alaorden.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoItemController {
    CarritoItemService carritoItemService;

    @Autowired
    public CarritoItemController(CarritoItemService carritoItemService){
        this.carritoItemService = carritoItemService;
    }
    @RequestMapping
    List<CarritoItem> ListCarrito(){
        return carritoItemService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    CarritoItem FindById(@PathVariable int id){
        return carritoItemService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    CarritoItem createCarrito(@RequestBody CarritoItem entity){
        return null;
    }

}