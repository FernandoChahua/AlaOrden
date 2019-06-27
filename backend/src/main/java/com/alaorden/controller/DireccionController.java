package com.alaorden.controllers;


import com.alaorden.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    private AddressService addressService;
    @Autowired
    public DireccionController(AddressService addressService){
        this.addressService = addressService;
    }
}
