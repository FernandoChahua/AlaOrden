package com.alaorden.controller;


import com.alaorden.model.Address;
import com.alaorden.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    private AddressService addressService;
    @Autowired
    public DireccionController(AddressService addressService){
        this.addressService = addressService;
    }

    @RequestMapping(method= RequestMethod.GET)
    List<Address> getAddresses(){
        return addressService.listAddress();
    }

    @RequestMapping(path="/{idUsuario}",method= RequestMethod.GET)
    List<Address> getAddresses(@PathVariable int idUsuario){
        return addressService.listAddressByUser(idUsuario);
    }
}
