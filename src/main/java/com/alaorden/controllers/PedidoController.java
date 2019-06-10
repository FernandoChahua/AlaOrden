package com.alaorden.controllers;
import com.alaorden.model.Pedido;
import com.alaorden.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    @RequestMapping
    List<Pedido> ListPedido(){
        return pedidoService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Pedido FindById(@PathVariable int id){
        return pedidoService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Pedido createPedido(@RequestBody Pedido entity){
        return null;
    }

}
