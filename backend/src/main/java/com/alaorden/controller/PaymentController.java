package com.alaorden.controller;

import com.alaorden.model.*;

import com.alaorden.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    @Autowired
    public PaymentController(OrderService orderService,OrderDetailService orderDetailService){
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    @RequestMapping(path="/listarpedidoxusuario/{usuario}",method=RequestMethod.PUT)
    Orders listarPedidoXUsuario(@PathVariable String usuario,@RequestBody Orders order){
        order.setUser(null);
        orderService.listOrderByUser(order);
        return order;
    }
}

