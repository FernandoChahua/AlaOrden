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
    private TransactionService transactionService;

    @Autowired
    public PaymentController(OrderService orderService,OrderDetailService orderDetailService,TransactionService transactionService){
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.transactionService = transactionService;
    }

    @RequestMapping(path="/{usuario}",method=RequestMethod.PUT)
    Orders listarPedidoXUsuario(@PathVariable String usuario,@RequestBody Orders order){
        order.setUser(null);
        orderService.listOrderByUser(order);
        return order;
    }
    @RequestMapping(method = RequestMethod.POST)
    Orders realizarPago(@RequestBody Orders order){

        Transaction transaction = new Transaction();
        transaction.setCardNumber(order.getTransaction().getCardNumber());
        transaction = transactionService.saveTransaction(transaction);

        order.setTransaction(transaction);

        order = orderService.SaveOrder(order);

        for(OrderDetail od : order.getOrderDetails()){
            od.getPk().setIdOrders(order.getIdOrders());
            od.setOrders(new Orders());
            od.getOrders().setIdOrders(order.getIdOrders());
        }
        orderDetailService.SaveDetailOrder(order.getOrderDetails());

        return order;

    }

    @RequestMapping(path="/coupon/{code}",method= RequestMethod.POST)
    Coupon checkCoupon(@PathVariable String code) {
        return this.transactionService.validarCoupon(code);
    }

    @RequestMapping(path="/coupon",method= RequestMethod.POST)
    Coupon activateCoupon(@RequestBody Coupon coupon) {
        return this.transactionService.saveCoupon(coupon);
    }
}

