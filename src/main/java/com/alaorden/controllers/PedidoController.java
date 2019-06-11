package com.alaorden.controllers;

import com.alaorden.model.CarritoItem;
import com.alaorden.model.Pedido;
import com.alaorden.model.Usuario;
import com.alaorden.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@RestController
@RequestMapping("/asdfg")
public class PedidoController {
    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @RequestMapping(path="/listarpedidoxusuario/{usuario}",method=RequestMethod.PUT)
    Pedido listarpedidoxusuario(@PathVariable String usuario,@RequestBody Pedido pedido){
        pedido.setUsuario("usuario");
        pedidoService.listarpedidoxusuario(pedido);
        return pedido;
    }

}

