package com.alaorden.controllers;
import com.alaorden.model.DetallePedido;
import com.alaorden.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallepedidos")
public class DetallePedidoController {
    DetallePedidoService detallePedidoService;

    @Autowired
    public DetallePedidoController(DetallePedidoService detallePedidoService){
        this.detallePedidoService = detallePedidoService;
    }
    @RequestMapping
    List<DetallePedido> ListDetallePedido(){
        return detallePedidoService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    DetallePedido FindById(@PathVariable int id){
        return detallePedidoService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    DetallePedido createDetallePedido(@RequestBody DetallePedido entity){
        return null;
    }

}
