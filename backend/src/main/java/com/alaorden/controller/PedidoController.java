package com.alaorden.controller;

import com.alaorden.model.CartItem;
import com.alaorden.model.Orders;
import com.alaorden.model.User;
import com.alaorden.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@RestController
@RequestMapping("/asdfg")
public class PedidoController {
    OrderService orderService;

    @Autowired
    public PedidoController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(path="/listarpedidoxusuario/{usuario}",method=RequestMethod.PUT)
    Orders listarpedidoxusuario(@PathVariable String usuario,@RequestBody Orders order){
        order.setUser(null);
        orderService.listOrderByUser(order);
        return order;
    }

}

