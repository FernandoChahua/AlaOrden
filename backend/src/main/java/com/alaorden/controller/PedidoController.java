package com.alaorden.controller;

import com.alaorden.model.CartItem;
import com.alaorden.model.OrderDetail;
import com.alaorden.model.Orders;
import com.alaorden.model.User;
import com.alaorden.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    OrderService orderService;

    @Autowired
    public PedidoController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(path="/listarpedidoxusuario/{usuario}",method=RequestMethod.PUT)
    Orders listarPedidoXUsuario(@PathVariable String usuario,@RequestBody Orders order){
        order.setUser(null);
        orderService.listOrderByUser(order);
        return order;
    }
}

