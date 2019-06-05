package com.alaorden.controllers;
import com.alaorden.model.DetallePedido;
import com.alaorden.service.ServiceDetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detallepedidos")
public class DetallePedidoController {
    ServiceDetallePedido serviceDetallePedido;

    @Autowired
    public DetallePedidoController(ServiceDetallePedido serviceDetallePedido){
        this.serviceDetallePedido = serviceDetallePedido;
    }
    @RequestMapping
    List<DetallePedido> ListDetallePedido(){
        return serviceDetallePedido.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    DetallePedido FindById(@PathVariable int id){
        return serviceDetallePedido.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    DetallePedido createDetallePedido(@RequestBody DetallePedido entity){
        return null;
    }

}
