package com.alaorden.controllers;
import com.alaorden.model.Cupon;
import com.alaorden.service.ServiceCupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cupones")
public class CuponController {
    ServiceCupon serviceCupon;

    @Autowired
    public CuponController(ServiceCupon serviceCupon){
        this.serviceCupon = serviceCupon;
    }
    @RequestMapping
    List<Cupon> ListCupon(){
        return serviceCupon.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Cupon FindById(@PathVariable int id){
        return serviceCupon.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Cupon createCupon(@RequestBody Cupon entity){
        return null;
    }

}
