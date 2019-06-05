package com.alaorden.controllers;
import com.alaorden.model.Pedido;
import com.alaorden.service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    ServicePedido servicePedido;

    @Autowired
    public PedidoController(ServicePedido servicePedido){
        this.servicePedido = servicePedido;
    }
    @RequestMapping
    List<Pedido> ListPedido(){
        return servicePedido.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Pedido FindById(@PathVariable int id){
        return servicePedido.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Pedido createPedido(@RequestBody Pedido entity){
        return null;
    }

}
