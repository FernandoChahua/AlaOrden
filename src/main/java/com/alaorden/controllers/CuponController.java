package com.alaorden.controllers;
import com.alaorden.model.Cupon;
import com.alaorden.service.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupones")
public class CuponController {
    CuponService cuponService;

    @Autowired
    public CuponController(CuponService cuponService){
        this.cuponService = cuponService;
    }
    @RequestMapping
    List<Cupon> ListCupon(){
        return cuponService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Cupon FindById(@PathVariable int id){
        return cuponService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Cupon createCupon(@RequestBody Cupon entity){
        return null;
    }

}
